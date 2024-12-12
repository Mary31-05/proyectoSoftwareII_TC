package utils;


import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import co.edu.unicauca.apiusuarios.core.domain.models.IUsuarioEntity;
import co.edu.unicauca.apiusuarios.core.domain.models.UsuarioBaseImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class TokenUtils {

    private static final String PUBLIC_KEY = 
        "-----BEGIN PUBLIC KEY-----\n" +
        "9CDGHFzqsX2IwaECRfyPojh7R5WJZxjso2QvzE_I7EY\n" + // Reemplaza con tu clave pública completa
        "-----END PUBLIC KEY-----";

    public static IUsuarioEntity extractUserInfoFromToken(String token) throws ParseException {
        // Parsear el token JWT
        SignedJWT signedJWT = SignedJWT.parse(token);
        
        // Obtener el conjunto de claims
        JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

        // Extraer los datos de usuario
        String id = claims.getStringClaim("sub");
        String name = claims.getStringClaim("name");
        String surname = claims.getStringClaim("preferred_username");
        String email = claims.getStringClaim("email");

        // Obtener el rol desde realm_access.roles
        String role = null;
        Object realmAccess = claims.getClaim("realm_access");
        if (realmAccess instanceof Map) {
            Map<String, Object> realmAccessMap = (Map<String, Object>) realmAccess;
            Object roles = realmAccessMap.get("roles");
            if (roles instanceof List) {
                List<?> rolesList = (List<?>) roles;
                if (!rolesList.isEmpty()) {
                    role = rolesList.get(0).toString(); // Tomar el primer rol
                }
            }
        }

        return new UsuarioBaseImpl(id, name, surname, email, role);
    }
}

