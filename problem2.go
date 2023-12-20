package main

// Queue is first in first out
// Below functions are copying what ever we have in queue S1 to stack S2 in reverse order.
// Pop and Peek operations are performed on S2

type MyQueue struct {
	S1 []int
	S2 []int
}

func Constructor() MyQueue {
	return MyQueue{}
}

func (s *MyQueue) Push(x int) {
	s.S1 = append(s.S1, x)
}

func (this *MyQueue) Pop() int {
	if len(this.S2) == 0 {
		for len(this.S1) != 0 {
			index := len(this.S1) - 1
			element := this.S1[index]
			this.S1 = this.S1[:index]
			this.S2 = append(this.S2, element)
		}
	}

	index := len(this.S2) - 1
	element := this.S2[index]
	this.S2 = this.S2[:index]

	return element
}

func (this *MyQueue) Peek() int {
	if len(this.S2) == 0 {
		for len(this.S1) != 0 {
			index := len(this.S1) - 1
			element := this.S1[index]
			this.S1 = this.S1[:index]
			this.S2 = append(this.S2, element)
		}
	}

	index := len(this.S2) - 1
	element := this.S2[index]

	return element
}

func (this *MyQueue) Empty() bool {
	if len(this.S1) == 0 && len(this.S2) == 0 {
		return true
	}
	return false
}
