'''
 In a queue, the element that is entered first is the one to come out first (FIFO - First In First Out), whereas in a stack, the last element entered comes out first (LIFO - Last In First Out).
'''


class MyQueue:
'''
init(self): Initializing my two stacks, s1 and s2, as empty lists.
'''
    def __init__(self):
        self.s1 = []
        self.s2 = []
        
'''
push(self, x: int): Adding a new element to my queue. To do so, I append the new element to the end of my first stack, s1.
'''
    def push(self, x: int) -> None:
        self.s1.append(x)

'''
pop(self): To remove an element from my queue. If my second stack, s2, is empty, I take all the elements from s1 and append them to s2. This effectively reverses the order of the elements. Then, I pop off the last element from s2, which would be the front element of my queue, and return it.
'''
    def pop(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()
        
'''
peek(self): To return the front element of my queue without removing it. Similar to the pop method, if s2 is empty, I transfer all the elements from s1 to s2. Then, return the last element from s2, which represents the front of my queue.
'''
    def peek(self) -> int:
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]

'''
empty(self): checking whether my queue is empty or not. If both my stacks, s1 and s2, are empty, I return True, indicating that my queue is empty. Otherwise, I return False.
'''
    def empty(self) -> bool:
         return not self.s1 and not self.s2
