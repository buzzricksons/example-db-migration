import lombok.*;

/**
 * DBマイグレーションで使われる設定を表すクラスです。
 *
 * @author HyungCheol Kim
 */
@Getter
@Builder
public class DBMigratorInfo {
    @NonNull
    private final String jdbc;
    @NonNull
    private final String userName;
    @NonNull
    private final String password;
}
