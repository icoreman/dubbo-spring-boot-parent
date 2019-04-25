### 简介
1、根据阿里官方提供的dubbo-spring-boot-starter 1.0.1 整合的dubbo 2.6.0和spring boot 1.5.10(不要死磕版本，老版本的优势在于稳定，前面很多人帮你填了坑)。

2、项目有四个工程，提供者provider(c&p)、消费者 consumer(c)、服务接口 api 、service(p)。

3、consumer项目是web项目，其他的为jar项目。

4、注意修改application.properties 配置文件中的zookeeper地址和端口号。


启动流程：
1、导入IDE，修改application.properties 配置文件中的zookeeper地址和端口号。
2、依次启动c&p/c/p,因为没有设置启动检查，所以可以不管启动顺序。
3、调用接口，验证是否成功.

调用流程：

1、服务提供方启动运行，向注册中心注册服务；

2、服务消费者启动运行，向注册中心注册，并订阅自己所需的服务。

3、注册中心返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送不变更数据给消费者。
