package com.example.demooauth2.configuations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceConfig")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private TokenEnhancer tokenEnhancer;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource);
    }

    /*@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("client1")
                .secret(passwordEncoder.encode("secret"))
                .scopes("read", "write")
                .authorities("CLIENT1_AUTH")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(60)
                .refreshTokenValiditySeconds(60 * 15)

                .and()

                .withClient("client2")
                .secret(passwordEncoder.encode("secret"))
                .scopes("read")
                .authorities("CLIENT2_AUTH")
                .authorizedGrantTypes("password")
                .accessTokenValiditySeconds(60);
//                .redirectUris()
    }*/

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain chain = new TokenEnhancerChain();
        chain.setTokenEnhancers(Arrays.asList());

        endpoints
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService)
                .tokenEnhancer(tokenEnhancer)
                .authenticationManager(authenticationManager);
    }
}
