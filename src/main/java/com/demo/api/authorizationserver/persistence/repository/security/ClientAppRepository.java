package com.demo.api.authorizationserver.persistence.repository.security;

import com.demo.api.authorizationserver.persistence.entity.security.ClientApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Client app repository.
 */
public interface ClientAppRepository extends JpaRepository<ClientApp, Long> {

  /**
   * Find by client id optional.
   *
   * @param clientId the client id
   * @return the optional
   */
  Optional<ClientApp> findByClientId(String clientId);

}
