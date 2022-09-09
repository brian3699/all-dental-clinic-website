package kr.alldent.alldentalclinicwebsite.domain.reservation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Service {

    SERVICE_FIRST_VISIT("SERVICE_FIRST_VISIT", "First time visiting the dental clinic"),
    SERVICE_SCALING("SERVICE_SCALING", "Dental scaling"),
    SERVICE_WHITENING("SERVICE_WHITENING", "Teeth whitening"),
    SERVICE_WISDOM_TEETH("SERVICE_WISDOM_TEETH", "Wisdom teeth extraction"),
    SERVICE_CAVITY_TREATMENT("SERVICE_CAVITY_TREATMENT", "Cavity treatment");

    private final String key;
    private final String description;
}
