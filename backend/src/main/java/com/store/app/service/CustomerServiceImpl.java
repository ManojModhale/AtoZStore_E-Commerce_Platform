package com.store.app.service;


import java.util.List;

import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.store.app.bean.Customer;
import com.store.app.bean.Address;

import com.store.app.dao.CustomerRepository;






@Service
public class CustomerServiceImpl implements CustomerService 
{     
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer loginUser(String username, String password) 
	{
		// TODO Auto-generated method stub
		return customerRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public void registerUser(Customer customer) 
	{
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public int getByEmail(String username, String email) 
	{

		Customer forgotpassUser=customerRepository.findByUsernameAndEmail(username, email);

	
		if(forgotpassUser!=null)
		{   
			return messageBodyforOTP(forgotpassUser.getEmail(), forgotpassUser.getFirstname(),forgotpassUser.getLastname());
		}
		else
		{
			return 0;
		}		
	}
	
	@Override
	public boolean changePassword(String username, String password) 
	{
		// TODO Auto-generated method stub

		Customer changePassUser=customerRepository.findByUsername(username);
		System.out.println(changePassUser.toString());
	

		
		if(changePassUser!=null)
		{   
			changePassUser.setPassword(password);
			customerRepository.save(changePassUser);

			return true;
		}
		return false;
		

	}
	
	


	
	

	private static int messageBodyforOTP(String recipient, String firstname, String lastname) {
		System.out.println("Preparing to send message!..");

		String subject = "Password Reset OTP - AtoZStore";
		String to = recipient;
		String from = "arkhambatman08@gmail.com";

		// Generate OTP
		int otpLength = 6;
		int generatedOTP = generateOTP(otpLength);
		System.out.println("Generated OTP : " + generatedOTP);

		// Create email body with OTP
		String body = "Dear " + firstname + " " + lastname + ",\n\n"
				+ "You have requested to reset your password for your 'AtoZStore' account. Please use the following One-Time Password (OTP) to complete the password reset process:\n\n"
				+ "OTP: " + generatedOTP + "\n\n"
				+ "This OTP is valid for a limited time. Please do not share this OTP with anyone. If you did not initiate this password reset, please disregard this email.\n\n"
				+ "Thank you for using AtoZStore.\n\n" + "Best Regards,";

		sendEmailforOTP(body, subject, to, from);

		return generatedOTP;
	}

	private static int generateOTP(int length) {
		String allowedChars = "0123456789";
		StringBuilder otp = new StringBuilder(length);
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(allowedChars.length());
			otp.append(allowedChars.charAt(index));
		}

		// Convert the OTP string to an integer
		return Integer.parseInt(otp.toString());
	}

	private static void sendEmailforOTP(String message, String subject, String to, String from) {
		// New Gmail host
		String host = "smtp.gmail.com";

		// System properties
		Properties properties = System.getProperties();
		System.out.println("Properties : " + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("arkhambatman08@gmail.com", "zpwy bunu fqfz pdmf");
			}
		});

		session.setDebug(true);

		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);

			Transport.send(mimeMessage);
			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}


	@Override
	public Customer getUser(String username) 
	{
		// TODO Auto-generated method stub
		return customerRepository.findByUsername(username);
	}

	@Override
	public void updateUser(Customer user) 
	{
		System.out.println("before update:"+user);
		// TODO Auto-generated method stub
		Customer updatedUser=customerRepository.findByUsername(user.getUsername());
		
		updatedUser.setFirstname(user.getFirstname());
		updatedUser.setLastname(user.getLastname());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setContactno(user.getContactno());
		updatedUser.setGender(user.getGender());
		updatedUser.setAge(user.getAge());
		
		customerRepository.save(updatedUser);
		
	}
	
	public Customer getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return customerRepository.findById(username).get();
	}
	
	@Override
	public void addAddress(String username, Address address) 
	{
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByUsername(username);
		customer.setAddress(address);
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getAllCustomers() 
	{
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	

}

