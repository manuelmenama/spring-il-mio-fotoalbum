package org.lessons.springilmiofotoalbum.api;

import org.lessons.springilmiofotoalbum.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contact")
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;
}
