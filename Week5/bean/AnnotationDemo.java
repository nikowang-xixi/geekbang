package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(AnnotationDemo.Config.class)
public class AnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDemo.class);
        context.refresh();
        Student s1 = context.getBean(Student.class);
        System.out.println(s1.toString());
        System.out.println(context.getBeanDefinitionNames());
        context.close();
    }

    public static class Config {
        @Bean
        public Student student() {
            Student student = new Student();
            student.setName("张三");
            student.setId((int) System.currentTimeMillis());
            return student;
        }
    }
}
