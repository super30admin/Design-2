class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
    def __init__(self):
        self.buckets = 10000
        self.array = [None] * self.buckets
        
    def put(self, key, value):
       hashKey = key % self.buckets

       if (not self.array[hashKey]):
            self.array[hashKey] = Node(key, value)

       else:
        currentNode = self.array[hashKey]

        while True:
            if (currentNode.key == key):
                currentNode.value = value
                return
            
            if (currentNode.next == None):
                break 
            currentNode = currentNode.next
           
        currentNode.next = Node(key, value)

    def get(self, key):
        hashKey = key % self.buckets
        
        currentNode = self.array[hashKey]

        while currentNode:
            if (currentNode.key == key):
                return currentNode.value

            else:
                currentNode = currentNode.next

        return -1

    def remove(self, key):
        hashKey = key % self.buckets

        prev = currentNode = self.array[hashKey]
        
        if not currentNode:
            return 

        if currentNode.key == key:
            self.array[hashKey] = currentNode.next

        currentNode = currentNode.next
        while currentNode:
            if currentNode.key == key:
                prev.next = currentNode.next
                break
            else:
                prev = currentNode
                currentNode = currentNode.next

