package com.devfuns.config.redisClusterConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisClusterConfig {


    @Value("${spring.redis.password}")
    String password;

    /**
     * Type safe representation of application.properties
     */
    @Autowired
    ClusterConfigurationProperties clusterProperties;

    @Bean
    public RedisClusterConfiguration redisClusterConfiguration() {
        RedisClusterConfiguration redisClusterConfiguration =
                new RedisClusterConfiguration(clusterProperties.getNodes());
        redisClusterConfiguration.setPassword(RedisPassword.of(password));
        return redisClusterConfiguration;
    }

    @Bean
    public RedisConnectionFactory connectionFactory(RedisClusterConfiguration clusterConfiguration) {
        return new JedisConnectionFactory(clusterConfiguration);
    }
}
