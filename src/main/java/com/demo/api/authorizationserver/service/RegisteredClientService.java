package com.demo.api.authorizationserver.service;

import com.demo.api.authorizationserver.exception.ObjectNotFoundException;
import com.demo.api.authorizationserver.mapper.ClientAppMapper;
import com.demo.api.authorizationserver.persistence.entity.security.ClientApp;
import com.demo.api.authorizationserver.persistence.repository.security.ClientAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

/**
 * The type Registered client service.
 */
@Service
public class RegisteredClientService implements RegisteredClientRepository {

  @Autowired
  private ClientAppRepository clientAppRepository;

  @Override
  public void save(RegisteredClient registeredClient) {

  }

  @Override
  public RegisteredClient findById(String id) {
    ClientApp clientApp = clientAppRepository.findByClientId(id)
              .orElseThrow(() -> new ObjectNotFoundException("Client not found"));
    return ClientAppMapper.toRegisteredClient(clientApp);
  }

  @Override
  public RegisteredClient findByClientId(String clientId) {
    return this.findById(clientId);
  }

}
