package main

import "fmt"

// hashSet - unordered unique elements
// which means, we do not have to necessarily store the value
// but just store whether it exists or not at a specific idx

type MyHashSet struct {
	items [][]bool
}

const (
	// where did I get this magic number?
	// well given I knew the number of items to be inserted
	// I had 2 choices
	// 1. allocate $max size from the start ( space heavy )
	// 2. allocate sqrt($max) and use nested array when time comes ( space optimized )

	arraySize      = 1000
	innerArraySize = arraySize + 1
)

// we will use double hashing to avoid collision of hash results that result to same idx.
// collision is when multiple different keys after hashing point to same idx in array,
// if they do point to same idx in array we will use nested list and double hashing to
// find uniq idx for each colliding key

func Constructor() *MyHashSet {
	// this only initializes the size of the outter array
	return &MyHashSet{items: make([][]bool, arraySize)}
}

/*
	time: o(1)
	space: o(1)
*/

func (hs *MyHashSet) hash(key int) int {
	return key % arraySize
}

/*
	time: o(1)
	space: o(1)
*/

func (hs *MyHashSet) hash2(key int) int {
	return key / innerArraySize
}

/*
	time: o(1)
	space: o(1) - but amortized
				- will be o($innerArraySize) at-least once for each idx
*/

func (hs *MyHashSet) Add(key int) {
	idx := hs.hash(key)
	innerIdx := hs.hash2(key)
	if hs.items[idx] == nil {
		hs.items[idx] = make([]bool, innerArraySize)
	}
	hs.items[idx][innerIdx] = true
}

/*
	time: o(1)
	space: o(1)
*/

func (hs *MyHashSet) Contains(key int) bool {
	idx := hs.hash(key)
	innerIdx := hs.hash2(key)
	if hs.items[idx] == nil {
		return false
	}
	return hs.items[idx][innerIdx]
}

/*
	time: o(1)
	space: o(1)
*/

func (hs *MyHashSet) Remove(key int) {
	idx := hs.hash(key)
	innerIdx := hs.hash2(key)
	if hs.items[idx] == nil {
		return
	}
	hs.items[idx][innerIdx] = false
}

func main() {
	hs := Constructor()
	fmt.Println(len(hs.items))
	fmt.Println(len(hs.items[0]))
	hs.Add(1)
	fmt.Println("Contains 2: ", hs.Contains(2))
	fmt.Println("Contains 1: ", hs.Contains(1))
}
