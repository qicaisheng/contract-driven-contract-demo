package com.qicaisheng.cdc.consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
public class Consumer2Application {

	private List<Student> students;

	public static void main(String[] args) {
		SpringApplication.run(Consumer2Application.class, args);
	}

	public List<Student> getStudents() {
		ParameterizedTypeReference<List<Student>> parameterizedTypeReference = new ParameterizedTypeReference<List<Student>>() {};
		String providerUrl = "http://localhost:8080/students";

		return new RestTemplate().exchange(providerUrl, HttpMethod.GET, null, parameterizedTypeReference).getBody();
	}
}
