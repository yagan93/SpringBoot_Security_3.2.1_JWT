package com.example.jwt.core.security.config;
/*
    The following code adds support to fetch the JWT related attributes from a HashiCorp Vault.
    1) docker run --name vault -p 8200:8200 --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault
    2) implementation group: 'org.springframework.cloud', name: 'spring-cloud-starter-vault-config', version: '3.1.1'

@Component
@VaultPropertySource(value = "secret/jwt", ignoreSecretNotFound = false)
public class JwtProperties {

    @Value("${expirationMillis}")
    private long expirationMillis;

    @Value("${issuer}")
    private String issuer;

    @Value("${secret}")
    private String secret;

    public JwtProperties() {
    }

    public JwtProperties(long expirationMillis, String issuer, String secret) {
        this.expirationMillis = expirationMillis;
        this.issuer = issuer;
        this.secret = secret;
    }

    public long getExpirationMillis() {
        return expirationMillis;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getSecret() {
        return secret;
    }

}

@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(URI.create(getEnvironment().getProperty("spring.cloud.vault.uri", "")));
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(getEnvironment().getProperty("spring.cloud.vault.token", ""));
    }
}
 */
