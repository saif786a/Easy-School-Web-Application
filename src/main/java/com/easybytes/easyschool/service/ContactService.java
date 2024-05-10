package com.easybytes.easyschool.service;

import com.easybytes.easyschool.controller.ContactController;
import com.easybytes.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ContactService {


    public boolean SaveMessageDeatails(Contact contact)
    {
        boolean isSaved= true;

        log.info(contact.toString());
        return isSaved;
    }

}
