/*
 *                     GNU GENERAL PUBLIC LICENSE
 *                        Version 3, 29 June 2007
 *
 *  Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 *  Everyone is permitted to copy and distribute verbatim copies
 *  of this license document, but changing it is not allowed.
 *
 *                             Preamble
 *
 *   The GNU General Public License is a free, copyleft license for
 * software and other kinds of works.
 *
 *   The licenses for most software and other practical works are designed
 * to take away your freedom to share and change the works.  By contrast,
 * the GNU General Public License is intended to guarantee your freedom to
 * share and change all versions of a program--to make sure it remains free
 * software for all its users.  We, the Free Software Foundation, use the
 * GNU General Public License for most of our software; it applies also to
 * any other work released this way by its authors.  You can apply it to
 * your programs, too.
 *
 * Nombre de archivo: User
 * Autor: 319207
 * Fecha de creación: septiembre 15, 2023
 */

package com.demo.api.authorizationserver.persistence.entity.security;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type User.
 */
@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User implements UserDetails {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * The Username.
   */
  @Column(unique = true)

  @Getter(AccessLevel.NONE)
  private String username;
  /**
   * The Name.
   */
  private String name;
  /**
   * The Password.
   */
  @Getter(AccessLevel.NONE)
  private String password;

  /**
   * The Role.
   */
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  /**
   * Gets authorities.
   *
   * @return the authorities
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (Objects.isNull(role)) return null;

    if (Objects.isNull(role.getPermissions())) return null;

    List<SimpleGrantedAuthority> authorities = role.getPermissions().stream()
            .map(item -> item.getOperation().getName())
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role.getName()));
    return authorities;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  @Override
  public String getPassword() {
    return password;
  }

  /**
   * Gets username.
   *
   * @return the username
   */
  @Override
  public String getUsername() {
    return username;
  }

  /**
   * Is account non expired boolean.
   *
   * @return the boolean
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * Is account non locked boolean.
   *
   * @return the boolean
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * Is credentials non expired boolean.
   *
   * @return the boolean
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * Is enabled boolean.
   *
   * @return the boolean
   */
  @Override
  public boolean isEnabled() {
    return true;
  }

}
