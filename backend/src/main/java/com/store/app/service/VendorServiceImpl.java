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
import com.store.app.bean.DeliveryPartner;
import com.store.app.bean.Products;
import com.store.app.bean.Vendor;
import com.store.app.dao.ProductsRepository;
import com.store.app.dao.VendorRepository;
@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    ProductsRepository productsRepository;
	@Override
	public Vendor vendorLogin(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		System.out.println(vendorRepository.findByUsernameAndPassword(username,password));
		Vendor vendor = vendorRepository.findByUsernameAndPassword(username,password);
		if(vendor != null && "Accept".equals(vendor.getStatus())) {
	        return vendor;
	    }
		return null;
	}
	@Override
	public Vendor addVendor(Vendor vendor) {
		System.out.println(vendor.toString());
		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}
	@Override
	public Vendor getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return vendorRepository.findByUsername(username);
	}
	@Override
	public int update(Vendor vendor) {
		// TODO Auto-generated method stub
		Optional<Vendor>op=vendorRepository.findById(vendor.getUsername());
		
		if(op.isPresent()) {
			Vendor u1=op.get();
			
			u1.setFirstname(vendor.getFirstname());
			u1.setLastname(vendor.getLastname());
			u1.setGender(vendor.getGender());
			u1.setAge(vendor.getAge());
			u1.setEmail(vendor.getEmail());
			u1.setContactno(vendor.getContactno());
			u1.setCompanyname(vendor.getCompanyname());
			u1.setCompanytype(vendor.getCompanytype());
			u1.setAddress(vendor.getAddress());
			vendorRepository.save(u1);
			return 1;
		}
		return 0;
	}
	public int getByEmail(String username, String email) {
		// TODO Auto-generated method stub
		Vendor forgotpassUser=vendorRepository.findByUsernameAndEmail(username, email);

		
		if(forgotpassUser!=null)
		{   
			return messageBodyforOTP(forgotpassUser.getEmail(), forgotpassUser.getFirstname(),forgotpassUser.getLastname());
		}
		else
		{
			return 0;
		}	
	}
	public boolean changePassword(String username, String password) 
	{
		// TODO Auto-generated method stub

		Vendor changePassUser=vendorRepository.findByUsername(username);
		System.out.println(changePassUser.toString());
	

		
		if(changePassUser!=null)
		{   
			changePassUser.setPassword(password);
			vendorRepository.save(changePassUser);

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
	public List<Products> getVendorProducts(String username) {
		// TODO Auto-generated method stub
		Vendor vendor=vendorRepository.findByUsername(username);
//		return productsRepository.findByVendor(vendor);
		return vendor.getProducts();
	}
	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return vendorRepository.findAll();
	}
	@Override
	public boolean changeStatus(String username, String status) {
		// TODO Auto-generated method stub
		Vendor vendor=vendorRepository.findByUsername(username);
		System.out.println(vendor);
		if(vendor!=null)
		{
			vendor.setStatus(status);
			System.out.println(vendor);
			vendorRepository.save(vendor);
			return true;
		}
		return false;
	}

}
