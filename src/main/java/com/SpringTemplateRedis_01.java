package com;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-redis.xml","classpath:spring/spring-db.xml"})
public class SpringTemplateRedis_01
{

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void connectTest()
    {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-redis.xml");

        //redisTemplate.getClientList();
        //redisTemplate.opsForSet().add("a","b");
        System.out.println(redisTemplate.hasKey("a"));
        System.out.println("这是第一个测试");
    }
}
