package com.example.contactmanagement.controller;

import com.example.contactmanagement.entity.Contact;
import com.example.contactmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Display all contacts
    @GetMapping
    public String getAllContacts(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "contact-list";  // The contact list page (contact-list.html)
    }

    // Display the form to add a new contact
    // Display the form to add a new contact
    @GetMapping("/add")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";  // The form to add new contacts (contact-form.html)
    }

    // Handle form submission to add a new contact
    @PostMapping
    public String addContact(@ModelAttribute Contact contact, Model model) {
        try {
            contactService.saveContact(contact);  // This method checks for duplicates
            return "redirect:/contacts";  // Redirect to the list of contacts
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());  // Add the error message to the model
            model.addAttribute("contact", contact);  // Return the submitted contact so the user doesn't have to re-enter it
            return "contact-form";  // Return to the form
        }
    }

    // Display the form to edit an existing contact
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "edit-contact";  // The form to edit a contact (edit-contact.html)
    }

    // Handle form submission to update an existing contact
    @PutMapping("/{id}") // Changed to PUT mapping
    public String updateContact(@PathVariable Long id, @ModelAttribute Contact contact) {
        contact.setId(id);  // Set the ID for the update
        contactService.saveContact(contact);
        return "redirect:/contacts";  // Redirect to the list of contacts
    }

    // Handle deletion of a contact
    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";  // Redirect to the list of contacts
    }
}
