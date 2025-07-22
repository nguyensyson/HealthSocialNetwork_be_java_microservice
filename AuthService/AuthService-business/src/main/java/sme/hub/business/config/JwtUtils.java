package sme.hub.business.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtUtils {
    public static String getSubjectFromToken(String token) {
        String[] parts = token.split("\\.");
        if (parts.length < 2) throw new IllegalArgumentException("Invalid JWT token");

        String unsignedToken = parts[0] + "." + parts[1] + ".";

        Claims claims = Jwts.parserBuilder()
                .build()
                .parseClaimsJwt(unsignedToken)
                .getBody();

        return claims.getSubject();
    }
}
