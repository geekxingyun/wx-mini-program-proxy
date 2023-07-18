package com.xingyun.wxminiprogramproxy.framework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * 自定义身份验证管理器
 * @author qing-feng.zhao
 */
@Slf4j
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SWAGGER_ACCESS_ROLE="swagger-access-role";

    private static final String API_ADMIN_ACCESS_ROLE="api-admin-access-role";

    private static final String OPERATION_MAINTENANCE_ACCESS_ROLE="operation-maintenance-access-role";

    /**
     * passwordEncoder
     * @return
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 这个方法定义了哪些URL需要被保护那些URL不需要被保护
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //跨域配置 支持跨域
                .cors().configurationSource(corsConfigurationSource())
                .and()
                //config allow include frame page
                .headers().frameOptions().sameOrigin()
                .and()
                //Session 管理
                //ALWAYS:Always create an HttpSession
                //NEVER:Spring Security will never create an HttpSession, but will use the HttpSession if it already exists
                //IF_REQUIRED:Spring Security will only create an  HttpSession if required
                //STATELESS:Spring Security will never create an HttpSession and it will never use it to obtain the SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                //匹配某URL规则使用什么过滤器
                //swagger access
                .antMatchers("/read-api-page.do","/swagger-ui/**","/v3/**","/swagger-resources/**").hasAnyRole(SpringSecurityConfig.SWAGGER_ACCESS_ROLE,SpringSecurityConfig.API_ADMIN_ACCESS_ROLE)
                //测试服务必须通过Swagger测试
                .antMatchers("/test-service/**").hasAnyRole(SpringSecurityConfig.SWAGGER_ACCESS_ROLE,SpringSecurityConfig.API_ADMIN_ACCESS_ROLE)
                //运维权限
                .antMatchers("/shutdown.do").hasAnyRole(SpringSecurityConfig.OPERATION_MAINTENANCE_ACCESS_ROLE,SpringSecurityConfig.API_ADMIN_ACCESS_ROLE)
                //除上面外的所有请求过滤器放行
                .anyRequest().permitAll()
                .and()
                //使用默认的表单登陆认证方式 支持表单登陆 openid oauth2.0 saml2等多种认证方式
                .formLogin()
                //第一次如果拦截到非法请求,默认重定向到 /login 请求去处理
                //默认值/login 如果不配置会默认拦截/login请求并自动生成一个登陆页面 如果配置会指向自定义的登陆页面
                .loginPage("/toLoginPage.do")
                //执行登陆的请求处理 如果不配置会拦截/login 交给Spring Security 默认处理
                .loginProcessingUrl("/login")
                //要允许匿名访问
                .permitAll()
                .and()
                //注销登陆
                .logout()
                //注销成功后返回首页
                .logoutSuccessUrl("/")
                //清除认证
                .clearAuthentication(true)
                //不拦截
                .permitAll()
                .and()
                //添加自定义过滤器
//                .antMatcher("/chat-gpt-service/**")
//                //将参数1放到参数2的后面的位置顺序
//                //在UsernamePasswordAuthenticationFilter过滤器之后执行方法
//                .addFilter(apiAuthenticationFilter)
//                .antMatcher("/vue-element-admin/**")
//                .addFilter(webTokenAuthenticationFilter)
                //跨站请求伪造（CSRF）
                //这里需要将csrf 禁用否则会报不能跨域的错误
                .csrf().disable();
    }

    /**
     * AuthenticationManagerBuilder 它非常适合设置内存中的JDBC或LDAP用户详细信息
     * 或添加自定义UserDetailsService。
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用密码类型
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        String[] allowHeaders={
                "appType",
                "appVersion",
                "X-Token",
                "x-auth-token",
                "Content-Type",
                "X-Requested-With",
                "XMLHttpRequest",
                "X-Content-Type-Options",
                "X-XSS-Protection",
                "X-Frame-Options",
                "X-Content-Type-Options",
                "Content-Language",
                "Access-Control-Allow-Origin",
                "Cache-Control",
                "Connection"
        };
        CorsConfiguration configuration = new CorsConfiguration();
        //设置同源策略 *
        configuration.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
        configuration.setAllowedHeaders(Arrays.asList(allowHeaders));
        configuration.setAllowedHeaders(Arrays.asList(allowHeaders));
        configuration.setExposedHeaders(Arrays.asList(CorsConfiguration.ALL));
        configuration.setExposedHeaders(Arrays.asList(CorsConfiguration.ALL));
        //设置允许的方法
        configuration.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //拦截所有的请求
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //内存中保存登录信息
        return inMemoryUserDetailsManager();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails javaUserDetailsDev =
                User.builder()
                        //账号
                        .username("qing-feng.zhao")
                        //密码
                        .password("$2a$10$92.lQZ3GwOnjpRZke76qcuOiNcZ6uAcaB4q70BRVLMXg5cgV0OclK")
                        //角色
                        .roles(SpringSecurityConfig.API_ADMIN_ACCESS_ROLE)
                        //账户是否过期
                        .accountExpired(false)
                        //是否锁定账户
                        .accountLocked(false)
                        //是否禁用该用户
                        .disabled(false)
                        //登录凭据已过期
                        .credentialsExpired(false)
                        .build();
        // java后端
        return new InMemoryUserDetailsManager(javaUserDetailsDev);
    }
}

