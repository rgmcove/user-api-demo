package com.rago.userapidemo.repository;

import com.rago.userapidemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ruben.gomez
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}
