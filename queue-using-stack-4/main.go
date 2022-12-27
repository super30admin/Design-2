package main

import "fmt"

type MyQueue struct {
	// what type are we storing in the stacks?
	firstStack  []int
	secondStack []int
	//Peekz func (this *MyQueue)
}

func Constructor() MyQueue {
	// return an object to MyQueue
	return MyQueue{
		firstStack:  []int{}, // using a slice instead of a fixed size array
		secondStack: []int{}, // using a slice instead of a fixed size array
	}
}

func (this *MyQueue) Push(x int) {
	// add to top of first stack
	this.firstStack = append(this.firstStack, x)
}

// Pop will always happen from second stack.
// so whenever seocnd stack has no element, we will move all elements from first stack to second
func (this *MyQueue) Pop() int {
	// check if second stack does not have any value
	if len(this.secondStack) == 0 {
		// move all values to second stack
		for i := len(this.firstStack) - 1; i >= 0; i-- {
			this.secondStack = append(this.secondStack, this.firstStack[i])
			this.firstStack = this.firstStack[:i]
		}
	}
	poped := this.secondStack[len(this.secondStack)-1]
	// remove from stack
	this.secondStack = this.secondStack[:len(this.secondStack)-1]
	return poped
}

func (this *MyQueue) Peek() int {
	fmt.Println(len(this.firstStack))
	if len(this.secondStack) == 0 {
		for i := len(this.firstStack) - 1; i >= 0; i-- {
			this.secondStack = append(this.secondStack, this.firstStack[i])
			this.firstStack = this.firstStack[:i]
		}
	}
	return this.secondStack[len(this.secondStack)-1]
}

func (this *MyQueue) Empty() bool {
	if len(this.secondStack) == 0 && len(this.firstStack) == 0 {
		return true
	}
	return false
}

func main() {
	obj := Constructor()
	obj.Push(1)
	obj.Push(2)
	obj.Push(3)
	obj.Push(4)
	fmt.Println(obj.Peek())
	fmt.Println(obj.Pop())
	obj.Push(4)
	obj.Push(4)
}
