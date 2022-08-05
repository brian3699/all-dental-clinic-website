package kr.alldent.alldentalclinicwebsite.domain.reservation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Service {

    FIRST_VISIT("SERVICE_FIRST_VISIT", "First time visiting the dental clinic"),
    SCALING("SERVICE_SCALING", "Dental scaling"),
    WHITENING("SERVICE_WHITENING", "Teeth whitening");

    private final String key;
    private final String description;
}
