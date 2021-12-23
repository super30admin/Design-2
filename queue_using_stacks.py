'''
T.C: O(1) - push, pop, peek
S.C: O(N)
'''

class MyQueue:

    def __init__(self):
        self.f_list = list()
        self.len = 0
        self.s_list = list()
        

    def push(self, x: int) -> None:
        self.empty()
        self.f_list.append(x)
        self.len += 1


    def pop(self) -> int:
        if not self.empty():
            return self.s_list.pop()
        return -1
        

    def peek(self) -> int:
        if self.empty():
            return -1
        return self.s_list[-1]
        

    def empty(self) -> bool:
        if self.s_list:
            return False
        if self.f_list:
            while self.f_list:
                self.s_list.append(self.f_list.pop())
        if self.s_list:
            return False
        return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()