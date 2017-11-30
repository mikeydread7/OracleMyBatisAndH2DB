package com.mybatis.demo.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//@ActiveProfiles("h2")
public class InMemoryDBTest {
     
    @Resource
    private UserRepository userRepository;
     
    @Test
    public void givenStudent_whenSave_thenGetOk() {
    	User user = new User("John","blue",70,145,(java.sql.Date)new Date(),47); 
           userRepository.insertUser(user);
         
        List<User> user2 =  userRepository.selectUserAllUsers();
        assertEquals("John", 
        		user2.stream()
        		.filter(e->e.getUserName().equals("John"))
        		.findFirst().orElseGet(null));
    }
}

