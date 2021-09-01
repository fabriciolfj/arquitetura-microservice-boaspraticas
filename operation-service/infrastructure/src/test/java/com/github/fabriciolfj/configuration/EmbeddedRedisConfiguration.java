package com.github.fabriciolfj.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@TestConfiguration
@Slf4j
public class EmbeddedRedisConfiguration {

    private final RedisServer redisServer;

    public EmbeddedRedisConfiguration(final RedisProperties redisProperties) {
        this.redisServer = new RedisServer(redisProperties.getPort());
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Starting embedded Redis");
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Stopping embedded Redis");
        redisServer.stop();
    }
}