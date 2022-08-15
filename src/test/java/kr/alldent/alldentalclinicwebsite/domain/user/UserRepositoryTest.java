package kr.alldent.alldentalclinicwebsite.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
    Role role = Role.ADMIN;
    long phoneNumber = 00000000000;
    String email = "testemail@gmail.com";
    String name = "name";
    String photoUrl = "url.com";

    @Autowired
    public UserRepository userRepository;


    @Test
    public void testSave() {
        userRepository.save(User.builder()
                .role(role)
                .email(email)
                .name(name)
                .photoUrl(photoUrl)
                .build());

        List<User> userList = userRepository.findAll();

        User firstUser = userList.get(0);

        Assertions.assertEquals(role.getKey(), firstUser.getRole().getKey(),  "role is not saved correctly");
        Assertions.assertEquals(email, firstUser.getEmail(), "email is not saved correctly");
        Assertions.assertEquals(name, firstUser.getName(), "name is not saved correctly");
        Assertions.assertEquals(photoUrl, firstUser.getPhotoUrl(), "photourl is not saved correctly");
    }

    @Test
    public void testUpdate() {
        User firstUser = userRepository.findAll().get(0);

        //firstUser.update(Role.USER, email+1, name+1, photoUrl+1);

        Assertions.assertEquals(Role.USER.getKey(), firstUser.getRole().getKey(),  "role is not updated correctly");
        Assertions.assertEquals(email+1, firstUser.getEmail(),  "email is not updated correctly");
        Assertions.assertEquals(name+1, firstUser.getName(),  "firstName is not updated correctly");
        Assertions.assertEquals(photoUrl+1, firstUser.getPhotoUrl(),  "photourl is not updated correctly");
    }

}

