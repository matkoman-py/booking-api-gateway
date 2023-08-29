package com.bookingapigateway.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

public class BookingJwtValidator implements OAuth2TokenValidator<Jwt> {

    public static final String USER_ID_CLAIM = "userId";
    private final OAuth2Error error = new OAuth2Error(
            "invalid_token", "Jwt token is not valid. Mandatory claims are missing.", null);

    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {

        if (token.getClaims().containsKey(USER_ID_CLAIM)) {
            return OAuth2TokenValidatorResult.success();
        }

        return OAuth2TokenValidatorResult.failure(error);
    }
}
