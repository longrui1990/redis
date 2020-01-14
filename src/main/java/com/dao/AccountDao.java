package com.dao;

import com.bean.Account;
import com.bean.QueryVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface AccountDao {

    List<Account> getAllAccount();

    void saveAccount(Account account);

    void deleteById(String id);

    void updateById(@Param("id")String id, @Param("age")Integer age);

    Account findById(String id);

    int countAll();

    List<Account> findByQueryVO(QueryVO vo);
}
