package kr.alldent.alldentalclinicwebsite.domain.user;


import kr.alldent.alldentalclinicwebsite.domain.BaseEntity;
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
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String photoUrl;


    @Builder
    public User(Role role, String email, String firstName, String lastName, String photoUrl) {
        this.role = role;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
    }

    /**
     * Updates the User entity
     * @param role user's role in the website. Either general user or administrator
     * @param email user's email
     * @param firstName user's first name
     * @param lastName user's last name
     * @param photoUrl url of user's photo
     * @return updated User entity
     */
    public User update(Role role, String email, String firstName, String lastName, String photoUrl) {
        updateIfNotNull(this.role, role);
        updateIfNotNull(this.email, email);
        updateIfNotNull(this.firstName, firstName);
        updateIfNotNull(this.lastName, lastName);
        this.photoUrl =  photoUrl;

        return this;
    }

    // this is a helper method that ensures the local variable is only updated when the parameter is not null
    private void updateIfNotNull(Object curr, Object input){
        if(input != null) curr = input;
    }


    /**
     * Return user's role
     * @return user's role
     */
    public String getUserRoleKey(){
        return this.role.getKey();
    }



}
