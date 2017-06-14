import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * DBマイグレーションで使われる設定を表すクラスです。
 *
 * @author HyungCheol Kim
 */
@Data
@Builder
public class DBMigratorInfo {
    @NonNull
    private String jdbc;
    @NonNull
    private String userName;
    @NonNull
    private String password;
}
