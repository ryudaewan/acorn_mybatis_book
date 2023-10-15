package ldg.mybatis.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFinder {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static ApplicationContext getContext() {
        return BeanFinder.applicationContext;
    }

    public static <T> T getBean(String name, Class<T> beanClass) {
        return BeanFinder.getContext().getBean(name, beanClass);
    }

}
