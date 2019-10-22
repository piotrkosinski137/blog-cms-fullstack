package com.blogen.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, EntityId> {

    User findByCredentialsEmail(String email);
}
