package com.rago.userapidemo.dtos;

import lombok.*;

/**
 * @author ruben.gomez
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String name;
    private String email;
}
