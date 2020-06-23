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

public class Calculator {
	
	public static final String FAIL_ON_NULL = "Operation can't be perfomed on null values.";
	public static final String FAIL_ON_EMPTY = "Operation can't be performed on empty vlaues.";
	
	public enum Mode {
		STANDARD(1),
		SCIENTIFIC(2);
		
		private Mode(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return value;
		}
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int add(Integer a, Integer b) {
		notNull(a, b);
		return a + b;
	}
	
	public int add(String a, String b) {
		notEmpty(a, b);
		Integer foo = Integer.parseInt(a);
		Integer bar = Integer.parseInt(b);
		return add(foo, bar);
	}
	
	public int abs(int a) {
		if (a < 0) {
			return -a;
		}
		return a;
	}
	
	private <T> void notNull(T a, T b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException(FAIL_ON_NULL);
		}
	}
	
	private void notEmpty(String a, String b) {
		notNull(a, b);
		if (a.length() ==  0 || b.length() == 0) {
			throw new IllegalArgumentException(FAIL_ON_EMPTY);
		}
	}

}
