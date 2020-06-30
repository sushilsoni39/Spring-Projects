package org.example;
import org.example.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;
public class App
{
    public static  void main(String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee emp = context.getBean("employee",Employee.class);
        System.out.println(emp);
        String beans[] = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beans));
    }
}