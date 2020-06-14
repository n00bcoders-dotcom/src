package com.n00bcoders.notNullAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.n00bcoders.notnullannotation.NotNullValidator;
import com.n00bcoders.pojo.Employee;

class NotNullValidatorTest {
	
	private NotNullValidator classUnderTest;
	
	@BeforeEach
	void setUp() {
		classUnderTest = new NotNullValidator();
	}

	@Test
	void testValidateNPE() throws IllegalArgumentException, IllegalAccessException {
		final Employee emp = new Employee(null, null, 62);
		assertThrows(NullPointerException.class, () -> classUnderTest.validate(emp));
	}
	
	@Test
	void testValidate() throws IllegalArgumentException, IllegalAccessException {
		final Employee emp = new Employee("Test", null, 62);
		classUnderTest.validate(emp);
	}

}
