package com.hardsurf.wardrober;

import com.hardsurf.wardrober.utils.StartedAtBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@SpringBootApplication
public class WardroberApplication {

	@Bean
	public StartedAtBean onStartUp() {
		return new StartedAtBean() {
			private final Instant startedAt = Instant.now();

			@Override
			public Instant getStartedAt() {
				return startedAt;
			}
		};
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(WardroberApplication.class, args);
	}

}
