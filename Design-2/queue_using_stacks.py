
'''
Did it run on leetcode: Yes
Challenges faced: Yes

How to make enQueue and deQueue operation both 0(1). Later I realized that, I can only make
one of the operation 0(1)

Algorithm:
1 -> Take two stacks, in one you will push elements and other as temporary.
2 -> Whenever you want to add a element add into elementsWillBePushedHere stack
3 -> Whenever you want to pop, pop all the elments from elementsWillBePushedHere and push it into
temp stack. Pop the top element of temp stack, which is your front element. 
'''


class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.elementsWillBePushedHere = []
        self.tempStack = []
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.elementsWillBePushedHere.append(x)
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if not self.tempStack:
            
            while self.elementsWillBePushedHere:
                self.tempStack.append(self.elementsWillBePushedHere.pop())
        
        return self.tempStack.pop()
                
        
        
    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        elem = self.pop()
        self.tempStack.append(elem)
        return elem
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return not self.elementsWillBePushedHere and not self.tempStack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()