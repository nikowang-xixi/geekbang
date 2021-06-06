package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionAPIDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Student.class);
        beanDefinitionBuilder.addPropertyValue("id", (int) System.currentTimeMillis());
        beanDefinitionBuilder.addPropertyValue("name", "李四");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBeanDefinition("Student", beanDefinitionBuilder.getBeanDefinition());
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), context);
        context.refresh();

        System.out.println(context.getBeansOfType(Student.class));
        context.close();
    }
}
