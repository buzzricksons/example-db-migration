# Example DB Migration
Example for DB Migration with flyway,H2 database and java.
- [flyway](https://flywaydb.org/)
- [H2 database](http://www.h2database.com/)

## Usage
1. If you already use the 8089 or 9099 port, then edit Web Port and Tcp Port of `resources/setting/setup.properties` file for your local.(default:webPort=`8089`,tcpPort=`9099`) 
2. Run main method of DBMigratorApplication.class.
3. Connect `http://localhost:8089/` (If you changed web port, then input your port number instead of 8089)
4. Push 接続 button. You can move to H2 console page.  
![](https://raw.githubusercontent.com/buzzricksons/sample-db-migration/master/src/main/resources/image/1.png)
5. Below message printed in IDE console.
```$xslt
[[[[Current DB Version： 0.00]]]]
> Input Number 1 or 0.(1:Execute DB Migration/0:exit)
``` 
6. Check 2 sql files in `resources/db/migration` folder.
- V1_00__20170926.sql
```sql 
CREATE TABLE TCITY (
    code VARCHAR(255)
);
```
- V2_00__20170926.sql
```sql
CREATE TABLE TCITY2 (
    code2 VARCHAR(255)
);

```
7. Input 1 at IDE console and enter. Then Below message printed.
```$xslt
There are executable DB Migrations： 2
Execution of 2 DB Migration success!
[[[[Current DB Version： 2.00]]]]
> Input Number 1 or 0.(1:Execute DB Migration/0:exit)
```
8. Refresh H2 Console page. You can see the two tables was added.
![](https://raw.githubusercontent.com/buzzricksons/sample-db-migration/master/src/main/resources/image/3.png)

9. Input 1 at IDE console and enter again. Then Below message printed.
```$xslt
There are no executable DB Migraion.
```
