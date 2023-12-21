'''
Time Complexity :
Push: O(n) in the worst case. But if first stack is already loaded then O(1)
Pop: O(n) in the worst case. But if second stack is already loaded then O(1)


Space Complexity : O(n) since we are using two linked lists to implement the queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

'''



class Node():

    def __init__(self,num,next=None):
        self.num = num
        self.next = next

class MyQueue:
    def __init__(self):
        self.first = None
        self.sec = None

    def load_first(self):
        if self.sec == None:
            return
        else:
            while self.sec:
                new_node = Node(self.sec.num)
                new_node.next = self.first
                self.first = new_node
                self.sec = self.sec.next
            return

    def load_sec(self):
        if self.first == None:
            return
        else:
            while self.first:
                new_node = Node(self.first.num)
                new_node.next = self.sec
                self.sec = new_node
                self.first = self.first.next
            return


    def push(self, x: int) -> None:
        if self.first is None:
            self.load_first()

        new_node = Node(x)
        new_node.next = self.first
        self.first = new_node
        return

    def pop(self) -> int:
        if self.sec is None:
            self.load_sec()

        popped = self.sec.num
        self.sec = self.sec.next
        return popped

    def peek(self) -> int:
        if self.sec is None:
            self.load_sec()

        popped = self.sec.num
        return popped


    def empty(self) -> bool:
        if self.sec is None and self.first is None:
            return True



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()