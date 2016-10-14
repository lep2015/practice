# IoC容器初始化
主要目的就是从用户指定的资源中加载bean并注册（放到一个HashMap中）
1. 定位资源，用户指定资源的位置
2. 加载资源，将指定资源加载并解析为BeanDefinition
3. 注册bean，将BeanDefinition添加到map中

# 依赖注入


FactoryBean和BeanFactory
BeanFactory：容器的基本接口，是一个工厂
FactoryBean：是一个特殊的Bean，可以当作工厂使用的Bean
	- 这个Bean特殊在哪儿：所有的Bean都是通过getBean等方法得到的，这个也是，只不过在获取这个Bean的时候会判断，如果没实现了FactoryBean这个接口的就直接返回从容器中返回的instance，如果是实现了该接口则会调用getObjectFromFactoryBean进一步获取

