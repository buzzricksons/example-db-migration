import lombok.*;

/**
 * DBマイグレーションで使われる設定を表すクラスです。
 *
 * @author HyungCheol Kim
 */
@Getter
@Builder
public class DataSource {
    @NonNull
    private final String jdbc;
    @NonNull
    private final String userName;
    private final String password;
}
