package org.yfr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args) {
        try {
            Controller controller = applicationContext.getBean("controller", Controller.class);
            System.out.println(controller.findName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
