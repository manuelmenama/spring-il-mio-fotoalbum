package org.lessons.springilmiofotoalbum.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.lessons.springilmiofotoalbum.exception.ContactNotFoundException;
import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Contact;
import org.lessons.springilmiofotoalbum.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Integer idParam) throws ContactNotFoundException {
        return contactRepository.findById(idParam).orElseThrow(() -> new ContactNotFoundException("Contact with id " + idParam + " not found!"));
    }

    public Contact createNewContact(Contact formContact) {
        Contact contactToCreate = new Contact();
        contactToCreate.setEmail(formContact.getEmail());
        contactToCreate.setTitle(formContact.getTitle());
        contactToCreate.setText(formContact.getText());
        contactToCreate.setCreatedAt(LocalDateTime.now());
        contactToCreate.setUpdatedAt(LocalDateTime.now());
        return contactRepository.save(contactToCreate);
    }

    public boolean deleteContact(Integer id) {
        contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException("Contact with id " + id + " not found!"));

        try {
            contactRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
