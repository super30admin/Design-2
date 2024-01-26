
"""
First I initialized a list and then initialized node as I get put request
If element already present I update it and if not present add to the linked list
For get I just iterate linked list bt getting the bucket position
For remove I iterate and with the help of prev pointer I remove the element
"""


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        self.eleCount = 100000
        self.buckets = [None] * self.eleCount

    def put(self, key: int, value: int) -> None:
        elePlace = key % self.eleCount
        print(elePlace)
        node = Node(key, value)
        if not self.buckets[elePlace]:
            self.buckets[elePlace] = node
        else:
            prev = None
            curr = self.buckets[elePlace]
            while curr:
                if curr.key == key:
                    curr.value = value
                    break
                prev = curr
                curr = curr.next
            else:
                prev.next = node

    def get(self, key: int) -> int:
        elePlace = key % self.eleCount
        if self.buckets[elePlace]:
            curr = self.buckets[elePlace]
            while curr:
                if curr.key == key:
                    return curr.value
                curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        elePlace = key % self.eleCount
        if self.buckets[elePlace]:
            prev = None
            curr = self.buckets[elePlace]
            while curr:
                if prev == None:
                    self.buckets[elePlace] = None
                    return
                if curr.key == key:
                    prev.next = curr.next
                    curr.next = None
                    return
                prev = curr
                curr = curr.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
