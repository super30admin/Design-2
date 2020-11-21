// Time Complexity : O(N/k)  k->number of buckets, N->number of values
// Space Complexity : O(K+N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

import java.util.LinkedList;

public class Hashset{
	
	private Bucket[] bucketArray;
	private int keyRange;
	
	public Hashset() {
		this.keyRange = 769;
	    this.bucketArray = new Bucket[this.keyRange];
	    for (int i = 0; i < this.keyRange; ++i) {
	    	this.bucketArray[i] = new Bucket();
	    }			
	}
	
	protected int _hash(int key) {
		return (key%this.keyRange);
	}
	public void add(int key) {
		int bucketIndex = this._hash(key);
	    this.bucketArray[bucketIndex].insert(key);
	}
	
	public void remove(int key) {
		int bucketIndex = this._hash(key);
	    this.bucketArray[bucketIndex].delete(key);
	}
	
	public boolean contains(int key) {
		int bucketIndex = this._hash(key);
	    return this.bucketArray[bucketIndex].exists(key);
	}
	
	class Bucket {
		  private LinkedList<Integer> container;

		  public Bucket() {
		    container = new LinkedList<Integer>();
		  }

		  public void insert(Integer key) {
		    int index = this.container.indexOf(key);
		    if (index == -1) {
		      this.container.addFirst(key);
		    }
		  }

		  public void delete(Integer key) {
		    this.container.remove(key);
		  }

		  public boolean exists(Integer key) {
		    int index = this.container.indexOf(key);
		    return (index != -1);
		  }
		}
	public static void main(String[] args) {
		Hashset obj = new Hashset();
		
		obj.add(1);
		obj.add(2);
		System.out.println(obj.contains(1));
		System.out.println(obj.contains(3));
		obj.add(2);
		System.out.println(obj.contains(2));		
		obj.remove(2);
		System.out.println(obj.contains(2));
		
	}
