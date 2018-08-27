package com.devfuns.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Set;

//@Configuration
//@EnableAutoConfiguration
public class RedisConfig {

    @Value("${spring.redis.sentinel.master}")
    private String master;

    @Value("${spring.redis.sentinel.nodes}")
    private Set<String> sentinelHostAndPort;


    @Value("${spring.redis.password}")
    private String password;


//    @Bean
    @ConfigurationProperties(prefix = "spring.sentinel")
    public RedisSentinelConfiguration getRedisSentinelConfig(){
        RedisSentinelConfiguration sentinelConfiguration =
                new RedisSentinelConfiguration(master,sentinelHostAndPort);
        sentinelConfiguration.setPassword(RedisPassword.of(password));
        return sentinelConfiguration;
    }

    /**
     * Jedis 使用Jedis
     */
//    @Bean
    @ConfigurationProperties(prefix = "spring.sentinel")
    public RedisConnectionFactory jedisConnectionFactory(RedisSentinelConfiguration sentinelConfig) {
        return new JedisConnectionFactory(sentinelConfig);
    }




//
//    /**
//     * Lettuce
//     */
//    @Bean
//    public RedisConnectionFactory lettuceConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("127.0.0.1", 26379)
//                .sentinel("127.0.0.1", 26380);
//        return new LettuceConnectionFactory(sentinelConfig);
//    }



}
