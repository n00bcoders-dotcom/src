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

package com.n00bcoders.junit5disabledtests;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache class to store key value pairs backed by {@link Map}
 * 
 * @author n00b
 * 
 */
public class Cache<K, V> {
	
	private Map<K, V> internalStore;
	
	public Cache() {
		this.internalStore = new HashMap<K, V>();
	}	
	
	/**
	 * Adds a key value pair to cache.
	 */
	public void add(K key, V value) {
		internalStore.put(key, value);
	}
	
	/**
	 * Removes an entry from the cache.
	 */
	public void remove(String key) {
		internalStore.remove(key);
	}
	
	/**
	 * Retrieves value of the corresponding key.
	 */
	public V get(K key) {
		return internalStore.get(key);
	}

}
