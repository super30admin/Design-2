class MyHashMap:
    class Node:

        def __init__(self, key, value):
            self.key = key                                    #creating keys
            self.value = value
            self.next = None

    def getbuckets(self, key):
        return key // self.buckets                         #getting the hash

    def find(self, key, head):
        prev = head                  #TC O(n) SC: O(1)
        curr = head.next            #creating a function to find the location of that particular key
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def __init__(self):                        #initializaing the buckets to 10000
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def put(self, key: int, value: int) -> None:
        buckets = self.getbuckets(key)
        if self.storage[buckets] == None:               #putting the key and values into the hashmap using linkedlists
                                                        #tc: O(1) sc: o(1)
            self.storage[buckets] = self.Node(-1, -1)
        else:
            prev = self.find(key, self.storage[buckets])
            if prev.next == None:
                prev.next = self.Node(key, value)
            else:
                prev.next.value = value

    def get(self, key: int) -> int:
        buckets = self.getbuckets(key)               #to get the values from the hashmap
        if self.storage[buckets] == None:               #tc: o(1) sc:o(1)
            return -1
        prev = self.find(key, self.storage[buckets])
        if prev.next == None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        buckets = self.getbuckets(key)
        if self.storage[buckets] == None:
            return                                     #to remove values from the hashmap
        prev = self.find(key, self.storage[buckets])    #tc: o(1) sc: o(1)
        if prev.next == None:
            return
        prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)