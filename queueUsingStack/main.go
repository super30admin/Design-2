package main

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to use 2 stacks ( as stacks )
stack1 -- primary stack used for pushing
stack2 -- this is the stack that we will flip stack1 into -
	- so that stack1 is upside down in stack2 - therefore FIFO starting from head of LL
*/

type StackNode struct {
	Val  int
	Next *StackNode
}

type MyQueue struct {
	stack1 *StackNode // primary stack
	stack2 *StackNode // flip stack1 in here
}

func Constructor() MyQueue {
	return MyQueue{
		stack1: nil, stack2: nil,
	}
}

/*
	time: o(n) where n is the number of nodes in stack1
	space: o(n) where n is the number of nodes in stack1 going to stack2
*/
func (this *MyQueue) flipStack1IntoStack2() {
	if this.stack2 == nil {
		currentS1 := this.stack1
		for currentS1 != nil {
			next := currentS1.Next
			topNode := currentS1
			newHead := &StackNode{Val: topNode.Val}
			if this.stack2 == nil {
				this.stack2 = newHead
			} else {
				newHead.Next = this.stack2
				this.stack2 = newHead
			}
			currentS1 = next
		}
		// since we emptied our stack1 in a sense -- we empty the head of stack1 by setting stack1 = nil
		this.stack1 = currentS1
	}

}

/*
	time: o(1)
	space: o(1)
*/
func (this *MyQueue) Push(x int) {
	newHead := &StackNode{Val: x}
	if this.stack1 == nil {
		this.stack1 = newHead
		return
	}
	newHead.Next = this.stack1
	this.stack1 = newHead
}

/*
	time: o(n) -- because of flipStack1IntoStack2()
	space: o(n) -- because of flipStack1IntoStack2()
*/
func (this *MyQueue) Pop() int {
	this.flipStack1IntoStack2()
	if this.stack2 != nil {
		out := this.stack2.Val
		newHead := this.stack2.Next
		this.stack2.Next = nil
		this.stack2 = newHead
		return out
	}
	return -1
}

/*
	time: o(n) -- because of flipStack1IntoStack2()
	space: o(n) -- because of flipStack1IntoStack2()
*/
func (this *MyQueue) Peek() int {
	this.flipStack1IntoStack2()
	if this.stack2 != nil {
		return this.stack2.Val
	}
	return -1
}

/*
	time: o(1)
	space: o(1)
*/
func (this *MyQueue) Empty() bool {
	return this.stack1 == nil && this.stack2 == nil
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
