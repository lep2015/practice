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
