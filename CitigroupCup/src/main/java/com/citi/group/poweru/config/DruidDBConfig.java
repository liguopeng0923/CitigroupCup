package com.dream.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunhuadong
 * @date 2020/5/21 12:40 上午
 */
@Configuration
public class DruidDBConfig {
    // 初始化druidDataSource对象
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 注册后台监控界面
    @Bean
    public ServletRegistrationBean<StatViewServlet> servletRegistrationBean() {
        // 绑定后台监控界面的路径  为localhost/druid
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        // 设置后台界面的用户名
        reg.addInitParameter("loginUsername", "root");
        //设置后台界面密码
        reg.addInitParameter("loginPassword", "123456");
        // 设置那些ip允许访问，" " 为所有
        reg.addInitParameter("allow", "");
        // 禁用HTML页面上的“Reset All”功能
        reg.addInitParameter("resetEnable", "false");
        // 不允许该ip访问
//        reg.addInitParameter("deny", "123.123.123.123");
        return reg;

    }

    // 监听获取应用的数据，filter用于收集数据，servlet用于数据展示
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<String, String>();
        //忽略过滤的形式
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
