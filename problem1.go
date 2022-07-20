// Queue using stacks

import (
    "container/list"
)

type Stack struct{
    data *list.List
}

func NewStack() *Stack {
    return &Stack{
        data: list.New(),
    }
}

func (s *Stack) Len() int {
    return s.data.Len()
}

func (s *Stack) Push(x int) {
    s.data.PushBack(x)
}

func (s *Stack) Pop() *list.Element {
    e := s.data.Back()
    s.data.Remove(e)
    return e
}

func (s *Stack) Peek() *list.Element {
    e := s.data.Back()
    return e
}

type MyQueue struct {
    pushStack *Stack
    popStack *Stack
    front int
}


func Constructor() MyQueue {
    return MyQueue {
        pushStack: NewStack(),
        popStack: NewStack(),
        front: 0,
    }
}

func MoveStack(source, target *Stack) {
    for source.Len() != 0 {
        e := source.Pop()
        target.Push(e.Value.(int))
    }
}

func (this *MyQueue) Push(x int)  {
    if this.pushStack.Len() == 0 {
        if this.popStack.Len() > 0 {
            this.front = this.popStack.Peek().Value.(int)
            MoveStack(this.popStack, this.pushStack)
        } else {
            this.front = x    
        }
    }
    this.pushStack.Push(x)
}


func (this *MyQueue) Pop() int {
    if this.popStack.Len() == 0 {
        if this.pushStack.Len() > 0 {
            MoveStack(this.pushStack, this.popStack)
        } else {
            return 0
        }
    }
    val := this.popStack.Pop().Value.(int)
    if this.popStack.Len() > 0 {
        this.front = this.popStack.Peek().Value.(int)
    } else {
        this.front = 0
    }
    return val
}


func (this *MyQueue) Peek() int {
    return this.front
}


func (this *MyQueue) Empty() bool {
    return this.pushStack.Len() == 0 && this.popStack.Len() == 0
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */