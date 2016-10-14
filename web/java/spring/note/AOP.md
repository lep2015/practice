# AOP
抽取重复代码单独维护
调用方式丰富：环绕增强

## advice
通知：定义连接点做什么，为切面提供织入接口

## pointcut
切点：决定作用点，advice作用于哪一个位置

## advisor
通知器：将通知和切点结合起来，决定哪一个通知advice作用于哪一个切点pointcut


[示例](http://www.jb51.net/article/83173.htm)
```
<!-- 创建一个增强 advice --> 
<bean id ="sleepHelper" class="com.tgb.springaop.aspect.SleepHelper"/> 

<bean id="lina" class="com.tgb.springaop.service.impl.ChenLliNa"/> 
<!-- 定义切点  匹配所有的sleep方法--> 
<bean id ="sleepPointcut" class="org.springframework.aop.support.JdkRegexpMethodPointcut"> 
  <property name="pattern" value=".*sleep"></property> 
</bean> 

<!-- 切面  增强+切点结合 --> 
<bean id="sleepHelperAdvisor" class="org.springframework.aop.support.DefaultPointcutAdvisor"> 
 <property name="advice" ref="sleepHelper"/> 
 <property name="pointcut" ref="sleepPointcut"/> 
</bean> 

<!-- 定义代理对象 --> 
<bean id="linaProxy" class="org.springframework.aop.framework.ProxyFactoryBean"> 
  <property name="target" ref="lina"/> 
  <property name="interceptorNames" value="sleepHelperAdvisor"/> 
  <!-- <property name="proxyInterfaces" value="com.tgb.springaop.service.Sleepable"/> --> 
</bean>
```