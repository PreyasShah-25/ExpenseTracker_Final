package com.grownited;



import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@SpringBootApplication
public class ExpenseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(5);
	}
	
	@Bean
	Cloudinary cloudinary() {
		Map<String, String> config = ObjectUtils.asMap("cloud_name", "duz2emkio", "api_key", "898888938875839",
				"api_secret", "vEra6eq1f9ozDgvTUv1I1EeUw1o");
		
		return new Cloudinary(config);
	}
	

}
