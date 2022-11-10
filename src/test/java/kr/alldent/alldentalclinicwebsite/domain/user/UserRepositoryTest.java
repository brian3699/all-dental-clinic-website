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





}

