class MyQueue:

    def __init__(self):
        self.f_list = list()
        self.len = 0
        self.s_list = list()
        

    def push(self, x: int) -> None:
        self.s_list = [val for val in self.f_list] #[self.f_list[idx] for idx in range(self.len - 1, -1, -1)]
        self.f_list = [x]
        self.f_list += [val for val in self.s_list] #[self.f_list[idx] for idx in range(self.len - 1, -1, -1)]
        self.s_list = list()
        self.len += 1
        # print(self.f_list)
        
    
    def pop(self) -> int:
        if self.empty():
            return -1
        self.len -= 1
        return self.f_list.pop()
        

    def peek(self) -> int:
        if self.empty():
            return -1
        return self.f_list[-1]
        

    def empty(self) -> bool:
        return True if not self.f_list else False
        
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()