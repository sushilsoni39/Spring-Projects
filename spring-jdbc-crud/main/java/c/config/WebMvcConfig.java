package c.config;

import c.dao.EmployeeDao;
import c.dao.EmployeeDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class WebMvcConfig {

    @Bean
    InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver vr = new InternalResourceViewResolver();

        vr.setPrefix("/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean
    DriverManagerDataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sushil");
        ds.setUsername("root");
        ds.setPassword("Mylogin@1");

        return ds;
    }

    @Bean
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl(getDataSource());
    }
}
