package com.rago.userapidemo.controller;

import com.rago.userapidemo.dtos.UserDTO;
import com.rago.userapidemo.entity.User;
import com.rago.userapidemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private IUserService userService;

    @GetMapping("/list/{page}/{size}")
    public ResponseEntity<?> getAll(@PathVariable int page, @PathVariable int size) {

        Page<UserDTO> list = userService.getAll(page, size);
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable int id) {

        UserDTO dto = userService.getUserById(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {

        UserDTO userDto = userService.save(user);
        if (userDto != null) {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
