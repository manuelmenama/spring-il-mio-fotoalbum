package org.lessons.springilmiofotoalbum.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.lessons.springilmiofotoalbum.exception.ContactNotFoundException;
import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Contact;
import org.lessons.springilmiofotoalbum.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Integer idParam) throws ContactNotFoundException {
        return contactRepository.findById(idParam).orElseThrow(() -> new ImageNotFoundException("Contact with id " + idParam + " not found!"));
    }
}
