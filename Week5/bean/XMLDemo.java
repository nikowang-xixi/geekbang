package lesson9.Q2;

import domian.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 在 XML 中定义
 */
public class XMLDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/xml-bean.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);
        User cxqUser = beanFactory.getBean(User.class);
        System.out.println(cxqUser);

        User userByFactoryBean = beanFactory.getBean("userFactoryBean", User.class);
        System.out.println("userByFactoryBean:" + userByFactoryBean);

        User userInstanceMethod = beanFactory.getBean("instanceMethod", User.class);
        System.out.println("userInstanceMethod:" + userInstanceMethod);

        User userStaticMethod = beanFactory.getBean("instanceStaticMethod", User.class);
        System.out.println("instanceStaticMethod:" + userStaticMethod);
    }
}
