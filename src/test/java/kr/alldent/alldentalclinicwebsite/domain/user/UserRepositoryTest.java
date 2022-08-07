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
    String firstName = "first";
    String lastName = "last";
    String photoUrl = "url.com";

    @Autowired
    public UserRepository userRepository;


    @Test
    public void testSave() {
        userRepository.save(User.builder()
                .role(role)
                .phoneNumber(phoneNumber)
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .photoUrl(photoUrl)
                .build());

        List<User> userList = userRepository.findAll();

        User firstUser = userList.get(0);

        Assertions.assertEquals(role.getKey(), firstUser.getRole().getKey(),  "role is not saved correctly");
        Assertions.assertEquals(phoneNumber, firstUser.getPhoneNumber(),  "phoneNumber is not saved correctly");
        Assertions.assertEquals(email, firstUser.getEmail(), "email is not saved correctly");
        Assertions.assertEquals(firstName, firstUser.getFirstName(), "firstName is not saved correctly");
        Assertions.assertEquals(lastName, firstUser.getLastName(), "lastName is not saved correctly");
        Assertions.assertEquals(photoUrl, firstUser.getPhotoUrl(), "photourl is not saved correctly");
    }

    @Test
    public void testUpdate() {
        User firstUser = userRepository.findAll().get(0);

        firstUser.update(Role.USER, phoneNumber+1, email+1, firstName+1, lastName+1, photoUrl+1);

        Assertions.assertEquals(phoneNumber+1, firstUser.getPhoneNumber(),  "phoneNumber is not updated correctly");
        Assertions.assertEquals(Role.USER.getKey(), firstUser.getRole().getKey(),  "role is not updated correctly");
        Assertions.assertEquals(email+1, firstUser.getEmail(),  "email is not updated correctly");
        Assertions.assertEquals(firstName+1, firstUser.getFirstName(),  "firstName is not updated correctly");
        Assertions.assertEquals(lastName+1, firstUser.getLastName(),  "lastName is not updated correctly");
        Assertions.assertEquals(photoUrl+1, firstUser.getPhotoUrl(),  "photourl is not updated correctly");
    }

}

