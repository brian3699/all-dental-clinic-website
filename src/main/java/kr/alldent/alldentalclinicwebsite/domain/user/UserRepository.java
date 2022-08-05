package kr.alldent.alldentalclinicwebsite.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * makes it possible to search for existing users during new customer register
     * @param PhoneNumber user's phone number
     * @return Optional<User>
     */
    Optional<User> findByPhoneNumber(Long PhoneNumber);
}
