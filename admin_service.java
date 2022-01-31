package com.klef.demo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class admin_service {

	 @Autowired
	 customer_repository rep;
	 @Autowired
	 customer_sellyourproperty_repository csyprop;
	 @Autowired
	 EntityManager entityManager;
	 
	 public List<customer_profile> get_customers_profile()
	 {
		 return (List<customer_profile>) rep.findAll();
	 }
	 
	 public List<customer_sellyourproperty> get_CustomerPropertyReq()
	 {
		 return (List<customer_sellyourproperty>) csyprop.findAll();
	 }
	 public void updateFCR(int id)
	 {
		 customer_sellyourproperty csyp=new customer_sellyourproperty();
		 csyp=csyprop.findById(id).get();
		 csyp.setStatus("Accepted");
		 csyprop.save(csyp);
	 }
}
