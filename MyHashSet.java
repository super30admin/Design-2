package com.Aug2020;

import java.util.HashMap;
import java.util.Map;
//Time Complexity : O(1)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : 
//Any problem you faced while coding this :

//how to make the solution work using one-stack only to avoid extra stack.
public class MyHashSet {
	
	Map<Integer, Integer> map;
	public MyHashSet() {
		// TODO Auto-generated constructor stub
		map = new HashMap<Integer, Integer>();
	}
	public void add(int value) {
		//: Insert a value into the HashSet. 
		if (!map.containsKey(value)) {
			map.put(value, value);
		}
		
	}
	public boolean contains(int value) {
		//: Return whether the value exists in the HashSet or not.
		if (map.containsValue(value)) {
			return true;
		}
		return false;
	}
	public void remove(int value) {
		//: Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
		if (map.containsValue(value)) {
			map.remove(value);
		}
		
	}
	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.contains(1); // returns true
		hashSet.contains(3); // returns false (not found)
		hashSet.add(2);
		hashSet.contains(2); // returns true
		hashSet.remove(2);
		hashSet.contains(2); // returns false (already removed)
	}
}
