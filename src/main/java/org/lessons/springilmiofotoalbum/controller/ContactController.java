package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping
    private String index(@RequestParam Optional<Integer> idParam, Model model) {
        if (idParam.isPresent()){
            model.addAttribute("selectedContact", contactService.getContactById(idParam.get()));
            model.addAttribute("contacts", contactService.getAllContacts());
        } else{
            model.addAttribute("selectedContact", null);
            model.addAttribute("contacts", contactService.getAllContacts());
        }
        return "contacts/index";
    }
}
