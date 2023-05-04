package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private IContactService contactService;

    @GetMapping
    public String testController() {
        return "Contacts controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name) {
        return "Contacts controller works, " + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod() {
        return "Contacts controller method works!";
    }

    @PostMapping(value = "/get")
    public ContactDto queryContact(@RequestBody ContactDto contactDto) {
        return contactService.queryContact(contactDto);
    }

    @GetMapping(value = "/getAll")
    public List<ContactDto> queryAllProducts() {
        return contactService.queryAllContacts();
    }

    @PostMapping(value = "/add")
    public Integer addContact(@RequestBody ContactDto contactDto) {
        return contactService.insertContact(contactDto);
    }

    @PostMapping(value = "/addAndShow")
    public ContactDto addContactAndShow(@RequestBody ContactDto contact) {
        Integer idContact = contactService.insertContact(contact);
        ContactDto newContact = new ContactDto();
        newContact.setId(idContact);
        return contactService.queryContact(newContact);
    }

    @PutMapping(value = "/update")
    public Integer updateContact(@RequestBody ContactDto contactDto) {
        return contactService.updateContact(contactDto);
    }

    @DeleteMapping(value = "/delete")
    public Integer deleteContact(@RequestBody ContactDto contactDto) {
        return contactService.deleteContact(contactDto);
    }
}
