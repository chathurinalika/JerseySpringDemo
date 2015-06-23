package com.demo.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.transaction.SaveTransaction;

@Path("/payment")
public class PaymentService {
	
	//Creating a bean using spring
	ApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SaveTransaction saveTransaction = Context.getBean("saveTransaction", SaveTransaction.class);
 
	/**
	 * Used spring bean in order to access method
	 * URI - http://localhost:8080/JerseySpringDemo/demo/payment/save
	 * 
	 * @return response
	 */
	@POST
	@Path("/save")
	@Produces(MediaType.TEXT_PLAIN)
	public Response savePayment() {
 
		String result = saveTransaction.save();
		return Response.status(200).entity(result).build();
	}
}
