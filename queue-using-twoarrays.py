class MyQueue:

    def __init__(self):
        self.arr1=[]
        self.arr2=[]
        # self.peek_idx
        
    def push(self, x: int) -> None:
        self.arr1.append(x)
        print("After pushing ", self.arr1)

    def pop(self) -> int:
        popped_item=self.arr1.pop(0)
        self.arr2.append(popped_item)
        return popped_item
        

    def peek(self) -> int:
        return self.arr1[0]                                                                                                                                                                                                                                                                                          

    def empty(self) -> bool:
        if len(self.arr1)==0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()