package kr.alldent.alldentalclinicwebsite.config.auth.dto;

import kr.alldent.alldentalclinicwebsite.domain.user.Gender;
import kr.alldent.alldentalclinicwebsite.domain.user.Role;
import kr.alldent.alldentalclinicwebsite.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String photoUrl;

    // Only Naver authenticated users
    // MM-DD form
    private String birthDay;
    private String age;
    private String phoneNumber;
    //F: female, M: male, U: unidentified
    private Gender gender;


    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email,
                           String photoUrl, String birthDay, String age, String phoneNumber, Gender gender) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.photoUrl = photoUrl;
        this.birthDay = birthDay;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .photoUrl((String) attributes.get("picture"))
                .birthDay(null)
                .age(null)
                .phoneNumber(null)
                .gender(null)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .photoUrl((String) response.get("profile_image"))
                .birthDay((String) response.get("birthday"))
                .age((String) response.get("age"))
                .phoneNumber((String) response.get("mobile"))
                .gender(changeStringToGender((String) response.get("gender")))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static Gender changeStringToGender(String gender){
        Gender eNumGender = Gender.U;
        if(gender != null) eNumGender = Gender.valueOf(gender);

        return eNumGender;
    }


    /**
     * Creates and returns the user entity from Google and Naver
     * @return User entity
     */
    public User toEntity() {

        return User.builder()
                .role(Role.USER)
                .email(email)
                .name(name)
                .photoUrl(photoUrl)
                .birthDay(birthDay)
                .age(age)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .build();
    }
}
