package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.Contact;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactService")
@Lazy
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto queryContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        return ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(contact.getId()));
    }


    @Override
    public List<ContactDto> queryAllContacts() {
        return ContactMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

    @Override
    public Integer insertContact(ContactDto contactDto) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.saveAndFlush(contact);
        return contact.getId();
    }

    @Override
    public Integer updateContact(ContactDto contactDto) {
        return insertContact(contactDto);
    }

    @Override
    public Integer deleteContact(ContactDto contactDto) {
        Integer id = contactDto.getId();
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDto);
        contactDao.delete(contact);
        return id;
    }
}
