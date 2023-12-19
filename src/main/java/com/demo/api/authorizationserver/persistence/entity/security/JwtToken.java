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
 * Nombre de archivo: JwtToken
 * Autor: 319207
 * Fecha de creación: septiembre 20, 2023
 */

package com.demo.api.authorizationserver.persistence.entity.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * The type Jwt token.
 */
@Entity
@Getter
@Setter
public class JwtToken {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * The Token.
   */
  @Column(length = 2040)
  private String token;

  /**
   * The Expiration.
   */
  private Date expiration;

  /**
   * The Is valid.
   */
  private boolean isValid;

  /**
   * The User.
   */
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

}
