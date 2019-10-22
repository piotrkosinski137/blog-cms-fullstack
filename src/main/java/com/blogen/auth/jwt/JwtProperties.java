package com.blogen.auth.jwt;

public class JwtProperties {
    public static final String SECRET = "SomeSecretForJWTGeneration"; //how will be hashed
    public static final int EXPIRATION_TIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
}
