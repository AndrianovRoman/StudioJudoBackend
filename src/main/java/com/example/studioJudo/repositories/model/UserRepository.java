package com.example.studioJudo.repositories.model;

import com.example.studioJudo.data.entity.Role;
import com.example.studioJudo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

    @Query("select u from User u join fetch u.roles where u.id = :id")
    Optional<User> findByIdWithRoles(@Param("id") Long id);

    @Query("select u from User u join fetch u.roles where u.email = :email")
    Optional<User> findByEmailWithRoles(@Param("email") String email);

    @Query("select r from User u join u.roles r where u.id = :id")
    List<Role> findRolesByUserId(@Param("id") Long id);

    boolean existsByEmail(String email);

}
