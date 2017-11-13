import migrator.DBMigrator;
import migrator.DBMigratorUtils;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * DBマイグレーションアプリケーションを表すクラスです。
 *
 * @author HyungCheol Kim
 */
public class DBMigratorApplication {
    public static void main(String[] args) throws SQLException {
        //Start H2 Web Server
        Properties prop = DBMigratorUtils.getProperty();
        Server webServer = Server.createWebServer("-webAllowOthers","-webPort",prop.getProperty("webPort")).start();
        Server server = Server.createTcpServer("-tcpAllowOthers","-tcpPort",prop.getProperty("tcpPort")).start();

        // Start DB Migration App
        for(;;) {
            DBMigrator migrator = DBMigratorUtils.makeExampleMigrator();
            System.out.println(String.format("[[[[Current DB Version： %s]]]]", migrator.currentVersion()));
            System.out.println("> Input Number 1 or 0.(1:Execute DB Migration/0:exit)");
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();

            if (i == 1) {
                if (!migrator.availableVersion().isEmpty()) {
                    System.out.println(String.format("There are executable DB Migrations： %s", migrator.migrateRows()));
                    System.out.println(String.format("Execution of %s DB Migration success!", migrator.migrate()));
                } else {
                    System.out.println("There are no executable DB Migraion.");
                }
            } else if (i == 0) {
                webServer.stop();
                server.stop();
                System.out.println("> Stop DB Migration App.");
                break;
            }
        }
    }
}
