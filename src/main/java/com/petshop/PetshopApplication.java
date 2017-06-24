package com.petshop;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.nio.file.Path;

@SpringBootApplication
@MapperScan("com.petshop.mapper")
public class PetshopApplication {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
//        factoryBean.setMapperLocations(patternResolver.getResources("classpath:/mapper/*.xml   "));
//        factoryBean.setTypeAliasesPackage("com.petshop.domain,");
//    }

    public static void main(String[] args) {
        SpringApplication.run(PetshopApplication.class, args);
    }
}
