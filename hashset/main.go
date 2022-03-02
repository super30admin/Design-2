package main

const (
	outterSize = 1000
	innerSize  = outterSize + 1
)

type boolVal bool
type MyHashSet struct {
	items [outterSize]interface{}
}

func Constructor() MyHashSet {
	return MyHashSet{
		items: [outterSize]interface{}{},
	}
}

func (s *MyHashSet) bucket(key int) int     { return key % outterSize }
func (s *MyHashSet) bucketItem(key int) int { return key / innerSize }

func (s *MyHashSet) Add(key int) {
	bucket := s.bucket(key)
	bucketItem := s.bucketItem(key)
	if s.items[bucket] == nil {
		s.items[bucket] = make([]boolVal, innerSize)
	}
	s.items[bucket].([]boolVal)[bucketItem] = true
}

func (s *MyHashSet) Contains(key int) bool {
	bucket := s.bucket(key)
	bucketItem := s.bucketItem(key)
	if s.items[bucket] == nil {
		return false
	}
	return bool(s.items[bucket].([]boolVal)[bucketItem])
}

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
