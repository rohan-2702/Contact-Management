package com.example.contactmanagement.repository;

import com.example.contactmanagement.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // JpaRepository provides built-in methods like save(), findAll(), findById(), deleteById(), etc.
    boolean existsByEmail(String email);
}


