package com.easybytes.easyschool.service;

import com.easybytes.easyschool.constant.EazySchoolConstants;
import com.easybytes.easyschool.controller.ContactController;
import com.easybytes.easyschool.model.Contact;
import com.easybytes.easyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy( EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,EazySchoolConstants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }


}
