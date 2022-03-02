package main

// hashSet - unordered unique elements
// which means, we do not have to necessarily store the value
// but just store whether it exists or not at a specific idx

const (
	// where did I get this magic number?
	// well given I knew the biggest key to be inserted
	// I had 2 choices
	// 1. allocate $biggestKey size from the start ( space heavy )
	// 2. allocate sqrt($biggestKey) and use nested array when time comes ( space optimized )
	bucketSize      = 1000
	bucketItemsSize = bucketSize + 1
)

// had to use a custom type for type assertion
// because I could not figure how to initialize nested
// fixed sized array in golang without pre-allocating initially
type boolVal bool
type MyHashSet struct {
	items [bucketSize]interface{}
}

func Constructor() MyHashSet {
	return MyHashSet{
		items: [bucketSize]interface{}{},
	}
}

// we will use double hashing to avoid collision of hash results that result to same idx.
// collision is when multiple different keys after hashing point to same idx in array,
// if they do point to same idx in array we will use nested list and double hashing to
// find uniq idx for each colliding key
/*
	time: o(1)
	space: o(1)
*/
func (s *MyHashSet) bucket(key int) int { return key % bucketSize }

/*
	time: o(1)
	space: o(1)
*/
func (s *MyHashSet) bucketItem(key int) int { return key / bucketItemsSize }

/*
	time: o(1)
	space: o(1) - but amortized
				- will be o($bucketItemSize) at-least once for each idx
*/
func (s *MyHashSet) Add(key int) {
	bucket := s.bucket(key)
	bucketItem := s.bucketItem(key)
	if s.items[bucket] == nil {
		s.items[bucket] = make([]boolVal, bucketItemsSize)
	}
	s.items[bucket].([]boolVal)[bucketItem] = true
}

/*
	time: o(1)
	space: o(1)
*/
func (s *MyHashSet) Contains(key int) bool {
	bucket := s.bucket(key)
	bucketItem := s.bucketItem(key)
	if s.items[bucket] == nil {
		return false
	}
	return bool(s.items[bucket].([]boolVal)[bucketItem])
}

/*
	time: o(1)
	space: o(1)
*/
func (s *MyHashSet) Remove(key int) {
	bucket := s.bucket(key)
	bucketItem := s.bucketItem(key)
	if s.items[bucket] == nil {
		// nothing to remove
		return
	}
	s.items[bucket].([]boolVal)[bucketItem] = false
}

func main() {
	s := Constructor()
	s.Add(1)
	s.Add(2)
	s.Add(2)
	s.Remove(2)
	s.Add(1000000)
}
