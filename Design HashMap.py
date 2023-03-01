# I'll perform hashmap using linear chaining and double hashing techniques
# Double hashing
class MyHashMap:

    def __init__(self):
        self.bucket = 1000
        self.storage = [None for i in range(self.bucket)]

    def put(self, key: int, value: int) -> None:
        if self.storage[key%self.bucket] == None:
            if key%self.bucket == 0:
                self.storage[key%self.bucket] = [-1 for i in range(self.bucket+1)]
            else:
                self.storage[key%self.bucket] = [-1 for i in range(self.bucket)]
        # print("Entered val at", [key%self.bucket],[key//self.bucket], value)
        self.storage[key%self.bucket][key//self.bucket] = value
        # print(self.storage)
    def get(self, key: int) -> int:
        if self.storage[key%self.bucket] == None:
            # print("1. Could not find", key)
            return -1
        return self.storage[key%self.bucket][key//self.bucket]

    def remove(self, key: int) -> None:
        if self.storage[key%self.bucket] == None:
            return
        if self.storage[key%self.bucket][key//self.bucket] == -1:
            return
        self.storage[key%self.bucket][key//self.bucket] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

# Linear Chaining
# Time Complexity: O(1)
# Space Complexity: O(n)

class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:
    def __init__(self):
        self.bucket = 10000
        self.storage = [None for i in range(self.bucket)]

    def put(self, key: int, value: int) -> None:
        if self.storage[key % self.bucket] == None:
            self.storage[key % self.bucket] = ListNode(-1, -1)
            self.storage[key % self.bucket].next = ListNode(key, value)

        else:
            prev = self.storage[key % self.bucket]
            curr = prev.next
            while curr != None and curr.key != key:
                prev = curr
                curr = curr.next
            if prev.next == None:
                prev.next = ListNode(key, value)
            else:
                prev.next.value = value
        prnt = self.storage[key % self.bucket]
        # while prnt:
        #     print("Key",prnt.key,"Val", prnt.value)
        #     prnt = prnt.next

    def get(self, key: int) -> int:
        if self.storage[key % self.bucket] == None:
            return -1
        prev = self.storage[key % self.bucket]
        curr = prev.next
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        if prev.next == None:
            return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        if self.storage[key % self.bucket] == None:
            return
        prev = self.storage[key % self.bucket]
        curr = prev.next
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        if prev.next == None:
            return
        prev.next = prev.next.next
        return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)