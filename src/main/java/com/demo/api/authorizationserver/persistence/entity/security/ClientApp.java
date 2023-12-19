package com.demo.api.authorizationserver.persistence.entity.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ClientApp {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String clientId;
  private String clientSecret;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> clientAuthenticationMethods;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> authorizationGrantTypes;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> redirectUris;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> scopes;

  private int durationInMinutes;

  private boolean requiredProofKey;


}
