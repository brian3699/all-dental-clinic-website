package kr.alldent.alldentalclinicwebsite.domain.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "Website's general user"),
    ADMIN("ROLE_ADMIN", "Administrator of the website");

    private final String key;
    private final String description;

}
