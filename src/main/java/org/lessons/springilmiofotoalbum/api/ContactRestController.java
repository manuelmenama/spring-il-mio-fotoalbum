package org.lessons.springilmiofotoalbum.api;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.model.Contact;
import org.lessons.springilmiofotoalbum.repository.ContactRepository;
import org.lessons.springilmiofotoalbum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @PostMapping
    public Contact contactCreated(@Valid @RequestBody Contact contact){
        return contactService.createNewContact(contact);
    }
}
