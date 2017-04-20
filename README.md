# springbootWeb

## 项目介绍

- 这是一个基于springboot的项目，项目提供了基本的搭建结构，以及相应的脚本。脚本包括用户表资源表等相关建表语句和预插入sql。
- 项目共分为五个模块，自下而上依次是`server-utility` ,`base-domain` , `busi-support` ,`busi-core` ,`webOOS` .
- 模块间只允许上级引用下级，下级不可引用上级，同级间不可相互引用
- 各模块介绍参见各模块`readme` 文件
- sql脚本在`base-domain` 的`resources` 目录下

## 项目组件

- `mail` 提供发送邮件功能
- `redisTemplate` 提供`redis` 数据操作
- `springSession` 解决多节点 `session` 共享问题
- `springCache` 结合`redis` 提供缓存功能
- 自定义注解解决`springCache` 默认存储时间为永久问题
- `springSecurity` 解决权限问题
- `mybatis` 结合 `druid` 多数据源配置
- `mybatisGenerator` 生成单表操作相关文件

