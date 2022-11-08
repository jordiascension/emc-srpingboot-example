package com.emc.demo;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmcWebApiJordiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmcWebApiJordiApplication.class, args);
	}

	@EventListener({ ApplicationReadyEvent.class })
	void applicationReadyEvent() {
		if (System.getenv("DYNO") == null) {
			System.out.println("Application started ... launching browser now");
			browse("http://localhost:8080/HelloWorld/hello");
		} else {
			System.out.println("You are in Heroku production environment");
		}
	}

	public static void browse(String url) {
		System.setProperty("java.awt.headless", "false");
		Desktop desktop1 = Desktop.getDesktop();
		try {
			desktop1.browse(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
