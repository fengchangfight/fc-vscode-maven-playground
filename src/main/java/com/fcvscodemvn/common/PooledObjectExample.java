package com.fcvscodemvn.common;

import org.apache.commons.pool2.PooledObject;

import redis.clients.jedis.Jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PooledObjectExample {
    public static final Logger logger = LoggerFactory.getLogger("PooledObjectExample");

    public void destroyObject(PooledObject<Jedis> p) throws Exception {
        final Jedis jedis = p.getObject();
        if (jedis.isConnected()) {
            try {
                try {
                    jedis.quit();
                } catch (Exception e) {
                    logger.warn(e.getMessage());
                }
                jedis.disconnect();
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        logger.info("Hello World2");
    }
}