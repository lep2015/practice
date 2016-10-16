package org.lep.springtest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lack on 16-10-16.
 */
public class TestAop {
    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("aop.xml");

        Sleep sleeper =(Sleep) ct.getBean("proxy");

        sleeper.sleep();
    }
}
