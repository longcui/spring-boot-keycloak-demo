// package com.example.demo;

// import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
// import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
// import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
// import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
// import org.keycloak.adapters.KeycloakConfigResolver;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
// import org.springframework.security.core.session.SessionRegistryImpl;
// import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
// import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

// @KeycloakConfiguration
// public class GlobalSecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {

//    /**
//     * Registers the KeycloakAuthenticationProvider with the authentication manager.
//      */
//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         // auth.authenticationProvider(keycloakAuthenticationProvider());
//         KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//         keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//         auth.authenticationProvider(keycloakAuthenticationProvider);
//     }

//     @Bean
//     @Override
//     protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//         // // TODO Auto-generated method stub
//         // return null;

//         //For SessionAuthenctionStartegy we should use RegisterSessionAuthenticationStrategy because we are using public Keycloak client for authentication.
//         return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//     }

//     /**
//      * Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.servlet.Filter]: Factory method 'springSecurityFilterChain' threw exception; nested exception is java.lang.IllegalStateException: 
// permitAll only works with either HttpSecurity.authorizeRequests() or HttpSecurity.authorizeHttpRequests(). Please define one or the other but not both.
//      */
//     @Override
//     protected void configure(HttpSecurity http) throws Exception
//     {
//         super.configure(http);
//         http
//                 .authorizeRequests()
//                 //    .antMatchers("/**").hasRole("default-roles-dev-idc")
//                 //  .anyRequest().permitAll();
//                 .antMatchers("/**").authenticated()
//                 .anyRequest().permitAll();
//     }
    
//     // @Bean ?
//     // @Autowired ?
//     public KeycloakConfigResolver setKeycloakConfigResolver() {
//         return new KeycloakSpringBootConfigResolver();
//     }


// }





// Currently, there is an issue with Spring Boot Keycloak adapter. But luckily, we have a workaround! Just create a new config class:

// @Configuration
// public class KeycloakConfig {

//    @Bean
//    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
// }