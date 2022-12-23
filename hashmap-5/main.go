package main

/*

Kep things to keep in mind
- how do you know which index a given k:v pair be stored?
	* you use the key for a given value and hash it to get the index in an  given array
- properties of a hashing function
	* is this that for a given value it always return a same value
	* for example dividing 100 by 10 will always give you the same answer
- how would you choose length of an array when you are given a number of elements to be stored
	* the correct answer is that it depends, you can start off by taking a square root of the number of elements if using an array. If you choose to use a LinkedList to store values then
traversing over it would take O(n) time and for this you might want to have more length on the outer array.
	* for this given question we are also given that At most 10carat4 (10 to the power of 4) calls will be made to put, get, and remove.
- you will be using the key to calculate the index at which we are going to store the key:value pair

*/

// going to do this with Double Hashing instead of Chaining hashing technique

type MyHashMap struct {
	// what are we storing -> key : value where key and values are both int
	hashmap          [][]*int
	outerArrayLength int
	innerArrayLength int
}

func Constructor() MyHashMap {
	hm := MyHashMap{}
	// given range os elements is 1000 * 1000 - so taking the square root for now and should suffice the current implementation
	hm.outerArrayLength = 1000
	hm.innerArrayLength = 1000 + 1 // for edge case we need an extra index in the inner array. edge case is the last number for a given range of values that can be stored in the map
	// only init the outer array for now
	hm.hashmap = make([][]*int, hm.outerArrayLength)
	return hm
}

func (this *MyHashMap) hashOuter(key int) int {
	return key % this.outerArrayLength
}

func (this *MyHashMap) hashInner(key int) int {
	return key % this.innerArrayLength
}

func (this *MyHashMap) Put(key int, value int) {
	outerIndex := this.hashOuter(key)
	innerIndex := this.hashInner(key)
	if this.hashmap[outerIndex] == nil { // there is no value at that given index yet and hence inner array does not exit
		this.hashmap[outerIndex] = make([]*int, this.innerArrayLength) // a bit optimized from last time when I had just initialized all the space in the Constructor in HashSet
	}
	this.hashmap[outerIndex][innerIndex] = &value // assign address as the DS is a pointer
}

func (this *MyHashMap) Get(key int) int {

	// to get a value, we need to the index at which its stored
	outerIndex := this.hashOuter(key)
	innerIndex := this.hashInner(key)
	if this.hashmap[outerIndex] == nil || this.hashmap[outerIndex][innerIndex] == nil {
		return -1
	}
	return *this.hashmap[outerIndex][innerIndex]
}

func (this *MyHashMap) Remove(key int) {

	outerIndex := this.hashOuter(key)
	innerIndex := this.hashInner(key)
	// if we are trying to remove a value that is not there return
	if this.hashmap[outerIndex] == nil || this.hashmap[outerIndex][innerIndex] == nil {
		return
	}
	this.hashmap[outerIndex][innerIndex] = nil
}

func main() {
	obj := Constructor()
	obj.Put(1, 3)

}
