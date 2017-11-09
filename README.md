# study-db-migration
Db migration example using [flyway](https://flywaydb.org/) and H2 database.

# How to use
Run main method of DBMigratorApplication.java



# Sample DB Migration
Sample for DB Migration with flyway,H2 database and java.
- [flyway](https://flywaydb.org/)
- [H2 database](http://www.h2database.com/)

## Usage
1. If you already use the 8089 or 9099 port, then edit Web Port and Tcp Port of `resources/setting/setup.properties` file for your local.(default:webPort=`8089`,tcpPort=`9099`) 
2. Run main method of `DBMigratorApplication` class.
3. Connect http://localhost:8089/ (If you changed web port, then input your port number instead of 8089)
4. Below message printed in IDE console.
```$xslt
[[[[Current DB Version： 0.00]]]]
> Input Number 1 or 0.(1:Execute DB Migration/0:exit)
``` 
4. 


3. Connect to `localhost:8880` or `localhost:8881` or `localhost:8882`. Below message printed.
```
current user: guest
```
4. Connect to `localhost:8880/login/?name=foobar`.Below message printed.
```
logined user: foobar (session ID: xxxxxxxxxxxxxxxxxx)
```
5. Connect `localhost:8880` or `localhost:8881` or `localhost:8882`. Below message printed.
```
current user: foobar
```

## Reference
### Spring Session
- http://kimulla.hatenablog.com/entry/2016/03/06/%E7%B0%A1%E5%8D%98_Spring_Session%E3%81%A7KVS%E3%82%92%E7%94%A8%E3%81%84%E3%81%9F%E3%82%BB%E3%83%83%E3%82%B7%E3%83%A7%E3%83%B3%E3%82%B9%E3%83%88%E3%82%A2
- https://stackoverflow.com/questions/26111050/spring-boot-how-can-i-add-tomcat-connectors-to-bind-to-controller

### Redis(via Docker)
- https://github.com/zokeber/docker-redis
