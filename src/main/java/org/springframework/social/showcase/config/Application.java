package org.springframework.social.showcase.config;

import con.domingosuarez.boot.social.google.EnableSpringSocialGoogle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.showcase.signin.SimpleSignInAdapter;

@ComponentScan(basePackages = "org.springframework.social.showcase")
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableSpringSocialGoogle
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public SignInAdapter signInAdapter() {
    return new SimpleSignInAdapter(new HttpSessionRequestCache());
  }

}