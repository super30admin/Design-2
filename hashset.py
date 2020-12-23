class LinkNode:
    def __init__(self,key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.array = [None] * self.size

    def add(self, key: int) -> None:
        index = key % self.size    #hashing function
        if self.array[index]:
            i = self.array[index]
            while i:
                if i.key == key:
                    return
                i = i.next
            newnode = LinkNode(key)
            newnode.next = self.array[index]
            self.array[index] = newnode  
            return
        else:
            self.array[index] = LinkNode(key)
        return

    def remove(self, key: int) -> None:
        index = key % self.size
        i = self.array[index]
        prev = None
        while i and i.key != key:
            prev = i
            i = i.next
        if not i:
            return
        else:
            if prev == None:
                self.array[index] = i.next
                return
            else:
                prev.next = i.next
                return

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key % self.size
        i = self.array[index]
        while i:
            if i.key == key:
                return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)