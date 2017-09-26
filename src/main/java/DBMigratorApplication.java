import org.flywaydb.core.Flyway;

public class DBMigratorApplication {
    public static void main(String[] args) {
        DataSource dataSource = DataSource.builder()
                .jdbc("jdbc:h2:mem:example-app;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
                .userName("sa")
                .password(null)
                .build();

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource.getJdbc(), dataSource.getUserName(), dataSource.getPassword());

        DBMigrator migrator = DBMigrator.builder()
                .flyway(flyway)
                .dataSource(dataSource)
                .build();

        System.out.println(String.format("DBマイグレーション成功! (%s件)", migrator.migrate()));
    }
}
