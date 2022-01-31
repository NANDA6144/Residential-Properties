package com.klef.demo;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customer_service {
	 @Autowired
	 customer_repository rep;
	 @Autowired
	 customer_sellyourproperty_repository sycprop;
	 @Autowired
	 EntityManager entityManager;
	 
	 public void add_customer_profile(customer_profile cp)
	 {
		 rep.save(cp);
	 }

	 public List<customer_profile> customerlogin(String email,String password)
	 {
		 Query query = entityManager.createQuery("select u from customer_profile u where u.email=:email and u.password=:password");
			query.setParameter("email",email);
			query.setParameter("password", password);
		    List<customer_profile> users = query.getResultList();
		    return users;
	 }
	 
	 public void add_customer_sellyourproperty(customer_sellyourproperty csyp)
	 {
		 sycprop.save(csyp);
	 }
	 
	 public List<customer_sellyourproperty> get_PropertyYouSold()
	 {
		 return (List<customer_sellyourproperty>) sycprop.findAll();
	 }
}
