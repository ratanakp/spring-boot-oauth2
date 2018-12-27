package com.example.demooauth2.configuations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

@Configuration
public class TokenStoreConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//        return new JdbcTokenStore(dataSource);
        return new JwtTokenStore(tokenConverter());
    }


    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setSigningKey("my-super-secret-key");
        return converter;
    }

    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setTokenStore(tokenStore());
        services.setSupportRefreshToken(true);
        return services;
    }

}

