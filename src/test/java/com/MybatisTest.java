package com;

import com.bean.Account;
import com.bean.QueryVO;
import com.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-redis.xml","classpath:spring/spring-db.xml"})

public class MybatisTest
{

    private InputStream inputStream = null;
    private SqlSession sqlSession = null;

    @Autowired
    private AccountDao accountDao ;


//    public void init()
//    {
//        String resource = "mybatis-config.xml";
//
//
//        try
//        {
//            inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            sqlSession = sqlSessionFactory.openSession(true);
//             dao = sqlSession.getMapper(AccountDao.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @After
    public void after()
    {
        sqlSession.close();
    }
    @Test
    public void test1()
    {
            List<Account> list = accountDao.getAllAccount();
            for(Account account :list)
            {
                System.out.println("账户信息：" +account);
            }
    }

    @Test
    public void saveTest()
    {
        Account ac = new Account();
        ac.setAge(10);
        ac.setId("4");
        ac.setName("liming");
        accountDao.saveAccount(ac);
    }

    @Test
    public void deleteByIdTest()
    {
        String id = "4";
        accountDao.deleteById(id);
    }

    @Test
    public void updateById()
    {
        Integer age = 30;
        String id = "3";
        accountDao.updateById(id,age);
    }

    @Test
    public void findById()
    {
        String id = "1";
        Account account = accountDao.findById(id);
        System.out.println(account);
    }

    @Test
    public void countAll()
    {
        System.out.println(accountDao.countAll());
    }

    @Test
    public void testQueryVO()
    {
        QueryVO vo = new QueryVO();
        Account ac = new Account();
        ac.setName("%a%");
        vo.setAccount(ac);
        List<Account> list = accountDao.findByQueryVO(vo);
    }


}
