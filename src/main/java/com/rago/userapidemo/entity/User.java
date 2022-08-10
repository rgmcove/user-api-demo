package com.rago.userapidemo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ruben.gomez
 */

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    private int id;
    private String name;
    private String email;

}
