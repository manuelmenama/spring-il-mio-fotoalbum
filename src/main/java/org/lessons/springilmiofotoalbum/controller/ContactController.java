package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.model.AlertMessage;
import org.lessons.springilmiofotoalbum.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/delete/{id}")
    private String deleteContact(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            boolean success = contactService.deleteContact(id);
            if (success) {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.SUCCESS, "Element with id " + id + " deleted with success."));
            } else {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Unable to delete element with id " + id));
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Element with id " + id + " not found."));
        }
        return "redirect:/contacts";
    }
}
