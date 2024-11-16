package com.example.contactmanagement.service;

import com.example.contactmanagement.entity.Contact;
import com.example.contactmanagement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // Get all contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Get contact by ID
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    // Save or update contact
    public void saveContact(Contact contact) {
        // Check if email already exists
        if (contactRepository.existsByEmail(contact.getEmail())) {
            throw new IllegalArgumentException("Email already exists, please use a different email.");
        }
        contactRepository.save(contact);
    }

    // Delete a contact
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}


