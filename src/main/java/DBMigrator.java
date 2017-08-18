import lombok.Getter;
import org.flywaydb.core.Flyway;

import lombok.Builder;
import lombok.Data;
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
    private DBMigratorInfo info;

    public int migrate() {
        return flyway.migrate();
    }

}
