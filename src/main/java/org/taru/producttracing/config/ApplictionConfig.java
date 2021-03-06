package org.taru.producttracing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.taru.producttracing.interceptor.AtuchInterceptor;


/**
 * JavaConfig 配置  @Configuration applicationContext.xml   IOC   基於XML      JavaConfig
 */
@Configuration
public class ApplictionConfig implements  WebMvcConfigurer{

    /**
     *跨域
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
            }
        };
    }

    /**
     *  <bean id="redisTemplate" class="org.taru.lanqiao.config.RedisTemplate"></bean>
     *  RedisConnectionFactory  可以默認
     * @return
     */
    @Bean
    public  RedisTemplate<String,Object>  redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(connectionFactory);
        StringRedisSerializer stringRedisSerializer =new StringRedisSerializer();
        JdkSerializationRedisSerializer  jdkSerializer =new JdkSerializationRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jdkSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jdkSerializer);
        return  redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }


   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(atuchInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/adminlogin","/api/loginout","/Api/**");
    }



    @Bean
    public AtuchInterceptor atuchInterceptor(){
        return  new AtuchInterceptor();
    }*/



}
