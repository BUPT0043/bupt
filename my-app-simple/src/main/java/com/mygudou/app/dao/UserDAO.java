package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Customer;
import com.mygudou.app.model.Lawyer;

/**
 * @UserInterface
 */
public interface UserDAO {

    void insertLawyer(Lawyer user);

    public boolean LawyerIsNotExist(int id);
    
    List<Lawyer> getLawyerSimpleList();
    
    Lawyer getLawyerDetail(int id);
            
    void insertCustomer(Customer user);

    public boolean CustomerIsNotExist(int id);
    
    Customer getCustomerDetail(int id);
    
    
}
