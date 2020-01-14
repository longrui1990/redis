package com;

import redis.clients.jedis.Jedis;

public class JedisClient_01 {
    public static void main(String[] args) {
        //test();

        Jedis jedis = RedisUtil.getConnect();
        System.out.println(jedis.ping());
    }
}
