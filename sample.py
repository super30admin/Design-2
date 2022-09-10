#Time-Complexity: O(1)
#Space-Complexity: O(n)

class MyQueue:

    def __init__(self):
        self.size=10
        self.ls=[[] for _ in range(self.size)]
        self.tail,self.head = -1,-1

    def push(self, x: int) -> None:
        if self.tail>=self.size:
            return "The Queue is full!"

        elif self.ls is None:
            self.head+=1
            self.tail+=1
            self.ls[self.tail]=x
            
       
        else:
            self.tail+=1
            self.ls[self.tail]=x
            
        print("Pushed Element is:")
        return self.ls[self.tail]
        
    def pop(self) -> int:
        if self.head+1>self.tail:
            return "No Element in Queue!"

        self.head+=1
        print("Popped Element is:")
        return self.ls[self.head]
        

    def peek(self) -> int:
        if self.head+1>self.tail :
            return "No Element in Queue!"

        print("Peeked element: ")
        return self.ls[self.head+1]
        

    def empty(self) -> bool:
        return self.head+1>self.tail

    def show(self):
        while self.head<=self.tail:
                self.head+=1
                print(self.ls)

Q = MyQueue()
print(Q.empty())
print(Q.peek())
print(Q.push(1))
print(Q.empty())
print(Q.push(2))
print(Q.push(3))
print(Q.peek())
print(Q.pop())
print(Q.peek())
print(Q.pop())
print(Q.pop())
print(Q.empty())
print(Q.pop())