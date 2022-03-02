package main

const (
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
