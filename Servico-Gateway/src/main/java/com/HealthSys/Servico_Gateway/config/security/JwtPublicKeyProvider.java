package com.HealthSys.Servico_Gateway.config.security;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class JwtPublicKeyProvider {

    private final PublicKey publicKey;

    public JwtPublicKeyProvider() throws Exception {
        this.publicKey = loadPublicKey("keys/public_key.pem");
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    private PublicKey loadPublicKey(String path) throws Exception {
        String key = readKeyFile(path)
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] decoded = Base64.getDecoder().decode(key);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }

    private String readKeyFile(String path) throws IOException {
        try (InputStream is = new ClassPathResource(path).getInputStream()) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}