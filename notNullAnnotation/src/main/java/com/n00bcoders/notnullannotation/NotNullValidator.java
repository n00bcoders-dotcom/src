package com.n00bcoders.notnullannotation;

import java.lang.reflect.Field;

public class NotNullValidator {
	
	public <T> void validate(T t) throws IllegalArgumentException, IllegalAccessException {
		if (t == null) {
			throw new IllegalArgumentException("Supplied argument can not be null.");
		}
		Field [] classFields = t.getClass().getDeclaredFields();
		if (classFields != null && classFields.length > 0) {
			for (Field field : classFields) {
				if (field.isAnnotationPresent(NotNull.class)) {
					field.setAccessible(true);
					Object fieldValue = field.get(t);
					if (fieldValue == null) {
						throw new NullPointerException(String.format("%s field should not be null.", field.getName()));
					}
				}
			}
		}
	}
}
