# springboot-template
使用SpringBoot+swagger快速构建的web项目模板
本仓库意在通过swagger+springboot快速构建restful接口风格的web项目。

《springboot-mybatis-mysql》
	本项目是一个简单的公司用户信息管理后台（UMS），采用springboot+swagger进行构建，对外提供了用户信息的增删改查接口，
数据层采用了Mybatis+Mysql的设计。Mybatis使用了动态SQL拼接的方式，可以为用户提供方便地任意字段查询、排序、分页等功能。
	源码使用教程请参考：https://juejin.im/post/5e7b60d1f265da42aa1029d1。本项目构建的swagger说明文件请参考swagger tools\swagger-codegen-2.4.5中的json文件。

《springboot-template-mongodb》
	本项目是springboot与mongodb的集成开发。基于《springboot-mybatis-mysql》框架，将数据层改用了MongoDB的设计来进行构建，对外提供了用户信息的增删改查接口，数据层操作采用的是MongoTemplate的相关接口进行实现，支持数据表任意字段的组合查询（包括and、or、is、like）、排序、分页等功能。
