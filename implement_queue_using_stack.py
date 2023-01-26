# // Time Complexity : Time complexity is O(1)
# // Space Complexity : Space complexity is O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# I have used 2 stacks here in the form of lists, one for pushing elements in the queue and 
# once pop is called, it will shift all the elements from the "inside" list to the "outside" 
# list till it is empty. And from the outside list it will pop out elements whenever pop operation is called.
# This will happen until the outside list gets empty. Peek operation just picks up the last element from the outside list
#Empty fucntion checks if both the inside and outside lists are empty by returning boolean valueKKllll



class MyQueue:

    def __init__(self):
        self.inside = []
        self.outside = []

    def push(self, x: int) -> None:
        self.inside.append(x)        

    def pop(self) -> int:
        if len(self.outside) == 0:
            while (len(self.inside) != 0):
                self.outside.append(self.inside.pop())
        return self.outside.pop()

    def peek(self) -> int:
        if len(self.outside) == 0:
            while (len(self.inside) != 0):
                self.outside.append(self.inside.pop())
        return self.outside[-1]

    def empty(self) -> bool:
        return len(self.outside) + len(self.inside) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()