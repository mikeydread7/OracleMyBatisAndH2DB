package com.mybatis.demo.repository;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("h2")
public class InMemoryDBTest {
     
    @Resource
    private UserRepository userRepository;
     
    @Test
    public void givenStudent_whenSave_thenGetOk() {
    	String userName = "JohnBGood";
    	User user = new User(1, userName,"blue",70,145,new Date(122L),47); 
           userRepository.insertUser(user);
         
        List<User> userSaved =  userRepository.selectUserAllUsers();
                
        		User userFound = userSaved.stream()
        		.filter(e->e.getUserName().equals(userName))
        		.findFirst().orElseGet(null);
        		 assertTrue( null != userFound &&  userFound.getUserName().equals(userName));
    }
}

