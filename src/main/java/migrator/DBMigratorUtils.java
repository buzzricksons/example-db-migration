package migrator;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * DBMigratorのUtilityクラスです。
 *
 * @author HyungCheol Kim
 */
public class DBMigratorUtils {
    /**
     * {@link DBMigrator}を生成します。
     *
     * @return DBMigrator
     */
    public static DBMigrator makeExampleMigrator () {
        Properties prop = getProperty();
        Flyway flyway = new Flyway();
        flyway.setDataSource(prop.getProperty("jdbcUrl"), prop.getProperty("userName"), prop.getProperty("password"));

        return DBMigrator.builder().flyway(flyway).build();
    }

    /**
     * resources/setting/setup.propertiesファイルをロードします。
     *
     * @return propertyファイル
     */
    public static Properties getProperty () {
        Properties prop = new Properties();
        try (InputStream is = DBMigrator.class.getClassLoader().getResourceAsStream("setting/setup.properties");
            Reader reader = new InputStreamReader(is)) {
            prop.load(reader);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("setup.properties cannot read.",e);
        }
    }
}
