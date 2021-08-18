package com.jake.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print out first and last name
			System.out.println("Students first name: " + student.getFirstName());
			System.out.println("Students last name: " + student.getLastName());
			
			// print out address
			Address address = student.getAddress();
			
			System.out.println("Street: " + address.getStreet());
			System.out.println("City: " + address.getCity());
			
			// print out languages for student
			for(String s : student.getLanguages()) {
				System.out.println(s);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
