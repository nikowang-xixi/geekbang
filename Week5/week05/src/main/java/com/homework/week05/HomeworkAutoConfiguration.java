package com.homework.week05;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(Student.class)
@ConditionalOnProperty(prefix = "homework", name = "enabled", havingValue = "true", matchIfMissing = true)
@ConditionalOnResource(resources = "META-INF/spring.factories")
@EnableConfigurationProperties(Student.class)
public class HomeworkAutoConfiguration {

    /**
     * ISchool Bean
     *
     * @return
     */
    @Bean
    public ISchool defaultSchool() {
        return new School();
    }

    /**
     * Student Bean
     *
     * @return
     */
    @Bean
    public Student defaultStudent() {
        return new Student();
    }

    /**
     * Klass Bean
     *
     * @return
     */
    @Bean
    public Klass defaultKlass() {
        return new Klass();
    }

}
