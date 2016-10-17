# IoC
## 怎么寻找需要注入的Bean
配置文件或者其他输入流——resource，spring根据不同的配置来源构造不同的Resource，然后解析resource
## 怎么初始化Bean
## 怎么解决依赖
## 怎么注入

RootBeanDefinition
BeanWrapperImpl
PropertyEditor
PropertyValues
PropertyValue

# AOP
## Java动态代理
静态代理：一个代理类只能代理一个类
动态代理：消除每个类都得编写一个静态代理类的方式，

## 使用JdkDynamicAopProxy和CglibProxyFactory的区别
jdk代理：生成的代理比如绑定接口
CGlib代理：没有jdk代理的缺陷，不必有接口

## 为什么执行sleep.sleep()的时候会直接跳转到JdkDynamicAopProxy.invoke方法
因为
```
Sleep sleep = (Sleep)context.getBean("proxy");
```
sleep是一个代理类的对象通过aopProxy.getProxy获得，该代理类由jdk生成，保存在内存中，实现了Sleep接口，在overridesleep方法中调用了proxy.invoke（proxy实现了InvocationHandler接口）

## advice织入，为什么不是直接调用各个advice增强方法，而是要通过调用Interceptor？
因为每个advice增强的方法都不一样，还得判断每个advice的类型来决定执行哪一个方法，而Interceptor有一个统一的invoke方法，便于统一调用，为了把Interceptor和advice对应起来就使用了adapter模式来适配


## 使用到的设计模式
- 责任链：interceptorChain
- 代理：jdk，cglib
- 适配器：三种advice对应的adapter，比如：MethodBeforeAdviceAdapter
- 单例：GlobalAdvisorAdapterRegister
- 工厂：用来生产proxy的CglibProxyFactory和

# Spring MVC
## ServletContext是什么鬼？
ServletContext是servlet-api，tomcat中ApplicationContext和ApplicationContextFacade实现了这个接口
## ApplicationContext和StandardContext是什么关系
- StandardContext：负责管理session，Cookie，Servlet的加载和卸载，负责请求信息的处理，掌握控制权
- ApplicationContext：servlet运行上下文，servlet从ApplicationContext获取运行环境上下文信息，加载资源，获取资源


