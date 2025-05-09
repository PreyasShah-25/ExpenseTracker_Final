package com.grownited.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
@Autowired
JavaMailSender javaMailSender;

public void sendWelcomeEmail(String email,String firstName) {
	String subject = "Welcome to ExpenseManager";
	String body = "Hey " + firstName
			+ ", We're excited to have you on board. If you have any questions, feel free to reach out – we’re here to help!";
	String from = "yusufsaiyed66@gmail.com";

	// logic
	SimpleMailMessage message = new SimpleMailMessage();

	message.setFrom(from);
	message.setTo(email);
	message.setSubject(subject);
	message.setText(body);

	javaMailSender.send(message);
}

public void sendOtpForForgetPassword(String email, String firstName,String otp) {
	String subject = "OTP for Resetpassword";
	String body = "Hey " + firstName
			+ ", It seems you have request for forget password, please use below otp for reset password.  If not then simply ignore the message!OTP:"+otp;
	String from = "yusufsaiyed66@gmail.com";

	// logic
	SimpleMailMessage message = new SimpleMailMessage();

	message.setFrom(from);
	message.setTo(email);
	message.setSubject(subject);
	message.setText(body);

	javaMailSender.send(message);

}
}
