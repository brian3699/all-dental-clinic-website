package kr.alldent.alldentalclinicwebsite.config.auth.dto;

import kr.alldent.alldentalclinicwebsite.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String photoUrl;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.photoUrl = user.getPhotoUrl();
    }
}
