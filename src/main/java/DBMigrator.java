import org.flywaydb.core.Flyway;

/**
 * DBマイグレーションを行います。
 * このクラスはイミュータブルではありません。マイグレーションが実行されるタイミングで結果が変わる場合があります。
 *
 * @author HyungCheol Kim
 */
public class DBMigrator {
    private Flyway flyway;
    private DBMigratorInfo info;

}
