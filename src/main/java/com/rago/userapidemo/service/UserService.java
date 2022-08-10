package com.rago.userapidemo.service;

import com.rago.userapidemo.dtos.UserDTO;
import com.rago.userapidemo.entity.User;
import com.rago.userapidemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ruben.gomez
 */

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Page<UserDTO> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<User> listUser = userRepository.findAll();
        List<UserDTO> list = listUser
                .stream().map(User -> modelMapper.map(User, UserDTO.class)).collect(Collectors.toList());

        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), list.size());

        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO save(User user) {
        User userNew = userRepository.save(user);
        return modelMapper.map(userNew, UserDTO.class);
    }

}
