package kr.alldent.alldentalclinicwebsite.config.auth.dto;

import kr.alldent.alldentalclinicwebsite.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String photoUrl;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.photoUrl = user.getPhotoUrl();
    }
}
