/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.Contact;
import com.oc.model.ContactId;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOContact {
        public void insertContact(Contact contact) throws Exception;
        public void deleteContact(Contact contact) throws Exception;
        public void updateContact(Contact contact) throws Exception;
        public Contact getContactById(ContactId contactId) throws Exception;
        public List<Contact> getContacts(String hql) throws Exception;
}
