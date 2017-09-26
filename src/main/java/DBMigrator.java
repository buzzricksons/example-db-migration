import lombok.Getter;
import org.flywaydb.core.Flyway;

import lombok.Builder;
import lombok.NonNull;

/**
 * DBマイグレーションを行います。
 * このクラスはイミュータブルではありません。マイグレーションが実行されるタイミングで結果が変わる場合があります。
 *
 * @author HyungCheol Kim
 */
@Getter
@Builder
public class DBMigrator {
    @NonNull
    private Flyway flyway;
    @NonNull
    private DataSource dataSource;

    public int migrate() {
        return flyway.migrate();
    }

}
