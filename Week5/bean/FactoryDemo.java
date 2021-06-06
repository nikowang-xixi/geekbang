package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class FactoryDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<Student> serviceLoader = beanFactory.getBean("studentFactoryServiceLoader", ServiceLoader.class);

        Iterator<Student> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.createStudent().getName());
        }

    }
}
