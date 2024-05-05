package com.easybytes.easyschool.service;

import com.easybytes.easyschool.controller.ContactController;
import com.easybytes.easyschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log= LoggerFactory.getLogger(ContactController.class);

    public boolean SaveMessageDeatails(Contact contact)
    {
        boolean isSaved= true;

        log.info(contact.toString());
        return isSaved;
    }

}
