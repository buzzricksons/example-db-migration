import lombok.Getter;
import org.flywaydb.core.Flyway;

import lombok.Builder;
import lombok.NonNull;
import org.flywaydb.core.api.MigrationInfo;

/**
 * DBマイグレーションを行います。
 * このクラスはイミュータブルではありません。マイグレーションが実行されるタイミングで結果が変わる場合があります。
 *
 * @author HyungCheol Kim
 *
 */
@Getter
@Builder
public class DBMigrator {
    @NonNull
    private final Flyway flyway;

    /**
     * DBマイグレーションを行い、マイグレーションされた件数を返します。
     *
     * @return マイグレーションされた件数
     */
    public int migrate() {
        return flyway.migrate();
    }

    /**
     * 呼ばれた時点に実行できるDBマイグレーションの件数を返します。実行できるマイグレーションが存在しない場合、0を返します。
     *
     * @return DBマイグレーションの件数
     */
    public int migrateRows() {
        try {
            return flyway.info().pending().length;
        } catch(NullPointerException e) {
            return 0;
        }
    }

    /**
     * 呼ばれた時点のDBのマイグレーションバージョンを返します。バージョンが存在しない場合、0.00を返します。
     *
     * @return DBのマイグレーションバージョン
     */
    public String currentVersion () {
        try {
            return flyway.info().current().getVersion().getVersion();
        } catch(NullPointerException e) {
            return "0.00";
        }
    }

    /**
     * 適用可能な一番最新のDBマイグレーションバージョンを返します。
     * <p>
     * 存在しない場合、空文字を返します。
     *
     * @return  DBマイグレーションバージョン
     */
    public String availableVersion() {
        MigrationInfo[] mi = flyway.info().pending();
        return mi.length > 0 ? mi[mi.length - 1].getVersion().getVersion() : "";
    }
}
