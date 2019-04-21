# MessageBoard SSM
Spring就像一个大水桶，把SpringMVC、Service层、MyBatis联合起来。

各个项目之前没什么业务逻辑上的联系，写在一起是为了利用Maven的模块管理
机制方便的管理依赖
## 总体思路

#### dao层
MyBatis与Spring整合，通过Spring 整理 mapper接口

使用 dao 的扫描器自动扫描mapper接口，并在Spring
中注册

#### service层
通过Spring配置Service接口

使用配置的方式将Service接口配置在Spring的配置文件中

实现事务控制

#### 整合SpringMVC
因为SpringMVC是Spring的一个模块，不需要专门的设置

如何给包、文件、函数命名？
- 每个额外的命名必须传递信息
- 尽量少的名称
- 信息论

https://blog.csdn.net/oMrLeft123/article/details/70237205
