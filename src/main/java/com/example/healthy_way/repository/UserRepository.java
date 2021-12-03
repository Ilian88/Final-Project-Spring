package com.example.healthy_way.repository;

import com.example.healthy_way.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

   Optional<UserEntity> findByUsername(String username);

   boolean existsByEmail(String email);

   @Query("SELECT u.username FROM UserEntity u ORDER BY u.username ASC")
   List<String> getAllUsernames();
}
