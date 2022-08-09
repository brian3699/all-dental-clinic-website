package kr.alldent.alldentalclinicwebsite.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Role defines three types of genders: Female, Male, and Unidentified
 * definition made identical to Naver login API
 *
 * @author Young Jun
 * @version 1.0
 * @since 2022-07-15
 */
@Getter
@RequiredArgsConstructor
public enum Gender {


    F("GENDER_FEMALE"),
    M("GENDER_MALE"),
    U("GENDER_UNIDENTIFIED");

    private final String key;
}
