package com.fcvscodemvn.common;

import org.apache.commons.pool2.PooledObject;

import redis.clients.jedis.Jedis;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PooledObjectExample {

    public void destroyObject(PooledObject<Jedis> p) throws Exception {
        final Jedis jedis = p.getObject();
        if (jedis.isConnected()) {
            try {
                try {
                    jedis.quit();
                } catch (Exception e) {
                    log.warn(e.getMessage());
                }
                jedis.disconnect();
            } catch (Exception e) {
                log.warn(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        log.info("Hello World4");
    }
}