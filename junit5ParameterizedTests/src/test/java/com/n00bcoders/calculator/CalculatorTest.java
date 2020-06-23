/*

BSD 3-Clause License

Copyright (c) 2020, n00bcoders.com
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/
package com.n00bcoders.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	
	private Calculator calculator;	
	
	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, -1, 2, -0})
	void testAbsoluteValue(int number) {
		assertTrue(calculator.abs(number) >= 0);
	}
	
	@ParameterizedTest
	@NullSource
	void testAddNullValue(Integer a) {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> calculator.add(a, new Integer(4)));
		assertEquals(Calculator.FAIL_ON_NULL, ex.getMessage());
	}
	
	@ParameterizedTest
	@EmptySource
	void testAddEmptyValue(String a) {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> calculator.add(a, "4"));
		assertEquals(Calculator.FAIL_ON_EMPTY, ex.getMessage());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	void testAddNullEmptyValue(String a) {
		assertThrows(IllegalArgumentException.class, () -> calculator.add(a, "4"));
	}
	
	@ParameterizedTest
	@EnumSource(Calculator.Mode.class)
	void testCalcModeValue(Calculator.Mode mode) {
		assertTrue(mode.getValue() > 0);
	}
	
	
	@ParameterizedTest
	@MethodSource("testAddSupplier")
	void testAdd(int a, int b) {
		assertEquals(a + b, calculator.add(a, b));
		
	}
	
	static Stream<Arguments> testAddSupplier() {		
		return Stream.of(Arguments.of(1, 2),
				Arguments.of(-1, -2),
				Arguments.of(-4, 3));
	}
	
	@ParameterizedTest
	@CsvSource({"-1, 1", "1, 9", "-3, -8", "6, -4"})
	void testAddCsv(int a , int b) {
		assertEquals(a + b, calculator.add(a, b));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "numbers.csv")
	void testAddCsvFromFile(int a , int b) {
		assertEquals(a + b, calculator.add(a, b));
	}
	
	@ParameterizedTest
	@ArgumentsSource(CaculatorArgumentProvider.class)
	void testAddArgumentSrc(int a , int b) {
		assertEquals(a + b, calculator.add(a, b));
	}

}
