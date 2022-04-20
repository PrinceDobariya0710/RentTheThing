package com.rent.project.authservice.UserRepositoryTests;

import com.rent.project.authservice.repository.User_Credentials_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserCredentialsRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private User_Credentials_Repository repo;

//    @Test
//    public void testCreateUser() {
//        UserCredentials user = new UserCredentials();
//        user.setEmail("test@gmail.com");
//        user.setPassword("test2022");
//        user.setUserName("testMe");
//        user.setCreatedAt(Date.valueOf("2022-04-07"));
//
//        UserCredentials savedUser = repo.save(user);
//
//        UserCredentials existUser = entityManager.find(UserCredentials.class, savedUser.getId());
//
//        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//
//    }
}
