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
import com.store.app.bean.Vendor;
import com.store.app.dao.DeliveryPartnerRepo;
@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService{
    @Autowired
    DeliveryPartnerRepo deliveryPartnerRepo;
	@Override
	public void registerDeliveryPartner(DeliveryPartner deliveryPartner) {
		
		deliveryPartnerRepo.save(deliveryPartner);
	}
	@Override
	public DeliveryPartner Login(String username, String password) {
		// TODO Auto-generated method stub
		DeliveryPartner deliveryPartner= deliveryPartnerRepo.findByUsernameAndPassword(username,password);
		if(deliveryPartner != null && "Accept".equals(deliveryPartner.getStatus())) {
	        return deliveryPartner;
	    }
		return null;
	}
	@Override
	public DeliveryPartner getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return deliveryPartnerRepo.findById(username).get();
	}
	@Override
	public int update(DeliveryPartner deliveryPartner) {
		// TODO Auto-generated method stub
Optional<DeliveryPartner>op=deliveryPartnerRepo.findById(deliveryPartner.getUsername());
		
		if(op.isPresent()) {
			DeliveryPartner u1=op.get();
			
			u1.setFirstname(deliveryPartner.getFirstname());
			u1.setLastname(deliveryPartner.getLastname());
			u1.setGender(deliveryPartner.getGender());
			u1.setAge(deliveryPartner.getAge());
			u1.setEmail(deliveryPartner.getEmail());
			u1.setContactno(deliveryPartner.getContactno());
			u1.setShippingAddress(deliveryPartner.getShippingAddress());
			u1.setVehicleRegNumber(deliveryPartner.getVehicleRegNumber());
			u1.setVehicleType(deliveryPartner.getVehicleType());
			
			deliveryPartnerRepo.save(u1);
			return 1;
		}
		return 0;
	
	}
	@Override
	public int getByEmail(String username, String email) {
		// TODO Auto-generated method stub
		DeliveryPartner forgotpassUser=deliveryPartnerRepo.findByUsernameAndEmail(username, email);

		
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

		DeliveryPartner changePassUser=deliveryPartnerRepo.findByUsername(username);
		System.out.println(changePassUser.toString());
	

		
		if(changePassUser!=null)
		{   
			changePassUser.setPassword(password);
			deliveryPartnerRepo.save(changePassUser);

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
	public List<DeliveryPartner> getAllDeliveryPartners() {
		// TODO Auto-generated method stub
		return deliveryPartnerRepo.findAll();
	}
	@Override
	public boolean changeStatus(String username, String status) {
		// TODO Auto-generated method stub
		DeliveryPartner deliveryPartner=deliveryPartnerRepo.findByUsername(username);
		if(deliveryPartner!=null)
		{
			deliveryPartner.setStatus(status);
			deliveryPartnerRepo.save(deliveryPartner);
			return true;
		}
		return false;
	}
	
	

}
