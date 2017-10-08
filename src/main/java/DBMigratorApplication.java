import migrator.DBMigrator;
import migrator.DBMigratorUtils;

public class DBMigratorApplication {
    public static void main(String[] args) {
        DBMigrator migrator = DBMigratorUtils.makeExampleMigrator();
        System.out.println(String.format("Current Version： %s", migrator.currentVersion()));
        System.out.println(String.format("DBマイグレーション件数： %s件", migrator.migrateRows()));
        System.out.println(String.format("DBマイグレーション成功! (%s件)", migrator.migrate()));
        System.out.println(String.format("Current Version： %s", migrator.currentVersion()));
    }
}
