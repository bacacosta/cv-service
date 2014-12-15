package com.chuvadasquatro;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		URL[] urls = ((URLClassLoader) cl).getURLs();

		System.out.println("Classpath loaded: ");
		for (URL url : urls) {
			System.out.println(url.getFile());
		}
	}
}
