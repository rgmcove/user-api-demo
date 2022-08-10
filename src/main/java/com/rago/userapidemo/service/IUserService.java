package com.rago.userapidemo.service;

import com.rago.userapidemo.dtos.UserDTO;
import com.rago.userapidemo.entity.User;
import org.springframework.data.domain.Page;

public interface IUserService {
    Page<UserDTO> getAll(int page, int size);

    UserDTO getUserById(int id);

    UserDTO save(User user);
}
