package com;


import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RedisUtil {

    private static String host = null;
    private static Integer port = null;
    private static String auth = null;
    private static Map<String ,String> map = new HashMap<>();


    static
    {
        InputStream in = RedisUtil.class.getClassLoader().getResourceAsStream("properties/redis.properties");
        Properties prop = new Properties();
        try
        {
            prop.load(in);
            Enumeration e = prop.keys();
            while(e.hasMoreElements())
            {
                 String key = (String) e.nextElement();
                 String value = (String) prop.getProperty(key);
                 map.put(key,value);
            }
            host = map.get("redis-host");
            port = Integer.valueOf(map.get("redis-port"));
            auth = map.get("redis-auth");


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Jedis getConnect()
    {

        Jedis jedis = new Jedis(host,port);
        jedis.auth(auth);
        return jedis;
    }

    public static void closeJedis(Jedis jedis)
    {
        jedis.close();
    }
}
