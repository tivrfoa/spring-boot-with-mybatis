package com.example;

import com.example.dao.PublisherMapper;
import com.example.dao.UserDao;
import com.example.model.Publisher;
import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DemoTests {

  @Autowired
  PublisherMapper publisherMapper;  // Mybatis generated bean

  @Autowired
  UserDao userDao;

  @Test
  public void testFindPublishers() {
    System.out.println( publisherMapper.getClass().getName());
    List<Publisher> publishers = publisherMapper.findAll();
    for (Publisher publisher : publishers) {
      System.out.println(publisher);
      assert publisher.getName() != null;
    }
    assert publishers.size() > 0;
  }

  @Test
  public void testFindsSomeUsers() {
    List<User> allUsers = userDao.findOrderedUsers();
    for (User user : allUsers) {
      System.out.println(user);
      assert user.getFirstName() != null;
    }
    assert allUsers.size() > 0;
  }
}
