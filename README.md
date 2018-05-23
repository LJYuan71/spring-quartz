## SpringQuartz定时任务

### Use technology
* spring.version 4.3.16
* quartz.version 2.3.0


### CN
* 1.RAMJobStore实现定时任务：最佳性能，因为所有数据都保存在内存中，但是应用程序或系统崩溃时，所有信息都会丢失。
* 2.JDBC+RAMJobStore自定义数据库表和RAM实现定时任务：一张表实现简单的动态定时任务，定时任务数据存储在内存，定时任务信息保存数据库
* 3.JDBCJobStore官方11张数据库表所有数据存储在数据库，可实现复杂任务(日历配置)

## 项目运行方法：
1.MySQL数据库启动导入数据(spring-quartz/quartz_test)且正确配置数据库连接<br/>
2.使用jetty:run启动项目(VM arguments:-server -Xms1024m -Xmx2048m -XX:PermSize=512m -XX:MaxPermSize=512m)


