#Time Complexity : O(n) ... n is number of elements 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : faced some issue with the pop function initially


#Your code here along with comments explaining your approach
#I am using 2 stacks to store the elements. For the push function, I simply append the elements and for the peek function I retrieve the element from the top of the stack. However,for the pop function, I am popping out the elements from the main s1 stack and storing them in the s2 stack which allows removal of the last element in the s1 stack and later on I again store the s2 stack elements in the reverse order in s1 stack.


class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        while len(self.s1) > 1:
            data = self.s1[-1]
            self.s2.append(data)
            self.s1.pop()
        popped = self.s1.pop()
    
        for data in reversed(self.s2):
            self.s1.append(data)
        self.s2 = []
        return popped

    def peek(self) -> int:
        return self.s1[0]

    def empty(self) -> bool:
        if self.s1:
            return False
        else:
            return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()