spring-base
=======

## 功能
1. 完成IOC功能
2. 完成AOp功能

## 总结分析
1. Ioc
> BeanFactory 实际是容器定义的接口，所有的实现类相当于容器。
而BeanDefinition映射了xml中的bean对象，包括类名称、属性等基本信息
同时还包括类名对应的Class对象，以及通过反射机制生成的实例对象。
容器会负责对BeanDefinition的初始化相关工作，并通过了一个Map对象保存
className 和 BeanDefinition 对象之间的一个映射关系。

> 如何从 xml 读取相关信息，并生成 BeanDefinition ？


### Ioc流程分析 
1. 操作对象定义：BeanDefinition 及相关属性 PropertyValue 、 BeanReference等。
2. IO相关流操作：把对应配置文件（.xml）转换成 inputStream 流。
3. XMLBeanDefinition 解析流，通过Document结点操作，把文件解析成 BeanDefinition对象（包括属性、ref关系等）获取到Map映射。
4. BeanFactory 工厂类主要功能实现：注册BeanDefinition，即ConcurrentHashMap建立名称与BeanDefinition的映射关系。
5. BeanFactory 工厂类主要功能实现：getBean功能，通过Java反射机制实现 Bean对象的实例化，若有ref关联对象，关联对象一并实例化。
6. ApplicationContext中实现了 加载资源文件，并把对象进行注册。


spring-jdbc
========

## 功能
1. 基本数据库配置
2. 数据库多数据源配置
3. 与mybatis联合操作
4. 事物相关操作


spring-mvc
========

## 功能
1. Spring-MVC框架搭建
2. 拦截器、监听器等设置
3. 常用注解使用熟悉、完成自定义注解实例
4. 结合Aop与注解，实现加密解密、数字签名验证、关键字信息脱敏等处理



