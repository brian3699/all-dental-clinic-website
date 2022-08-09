package kr.alldent.alldentalclinicwebsite.domain.user;


import kr.alldent.alldentalclinicwebsite.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * User is an entity class that defines the User table.
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Both Google and Naver authenticated users
    @Column
    private String email;

    // Both Google and Naver authenticated users
    @Column(nullable = false)
    private String name;

    // Both Google and Naver authenticated users
    @Column
    private String photoUrl;

    // Only Naver authenticated users
    // MM-DD form
    @Column
    private String birthDay;

    // Only Naver authenticated users
    @Column
    private String age;

    // Only Naver authenticated users
    @Column
    private String phoneNumber;

    // Only Naver authenticated users
    //F: female, M: male, U: unidentified
    @Column
    private Gender gender;


    @Builder
    public User(Role role, String email, String name, String photoUrl, String birthDay,
                String age, String phoneNumber, Gender gender) {
        this.role = role;
        this.email = email;
        this.name = name;
        this.photoUrl = photoUrl;

        // Only Naver authenticated users
        this.birthDay = birthDay;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

        /**
         * Updates the User entity
         * @param role user's role in the website. Either general user or administrator
         * @param email user's email
         * @param name user's name
         * @param photoUrl url of user's photo
         * @return updated User entity
         */
    public User update(Role role, String email, String name, String photoUrl, String birthDay,
                       String age, String phoneNumber, Gender gender) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.photoUrl =  photoUrl;

        // Only Naver authenticated users
        this.birthDay = birthDay;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        return this;
    }



    /**
     * Return user's role
     * @return user's role
     */
    public String getUserRoleKey(){
        return this.role.getKey();
    }



}
