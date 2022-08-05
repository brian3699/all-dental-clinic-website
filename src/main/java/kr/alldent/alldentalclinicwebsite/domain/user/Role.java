package kr.alldent.alldentalclinicwebsite.domain.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Role defines two types of users of this website: administrator and general user
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "Website's general user"),
    ADMIN("ROLE_ADMIN", "Administrator of the website");

    private final String key;
    private final String description;

}
