"""
I implemented a custom HashMap with the idea taught in the session using a list of size 10,000, where each index handles collisions through separate chaining with linked lists. Each key is mapped using key % 10000, and operations like put, get, and remove traverse the linked list at that index if needed
Time complexity: O(1) on average and O(N) in the worst case
Space complexity : O(N + M) where N is the number of buckets and M is the number of elements
"""
class MyHashMap:

    class Node():
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.hashList = [None] * 10000
    
    def finding_index(self, key):
        return key % len(self.hashList)

    def finding_node(self, head, key):
        prev = None
        curr = head
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.finding_index(key)
        if self.hashList[index] == None:
            self.hashList[index] = self.Node(-1,-1)
        prev_node = self.finding_node(self.hashList[index], key)
        if prev_node.next == None:
            prev_node.next = self.Node(key, value)
        else:
         prev_node.next.value = value

    def get(self, key: int) -> int:
        index = self.finding_index(key)
        if self.hashList[index] == None:
            return -1
        prev_node = self.finding_node(self.hashList[index], key)
        if prev_node.next == None:
            return -1
        else:
            return  prev_node.next.value
        
    def remove(self, key: int) -> None:
        index = self.finding_index(key)
        if self.hashList[index] == None:
            return
        prev_node = self.finding_node(self.hashList[index], key)
        if prev_node.next == None:
            return
        else:
            prev_node.next = prev_node.next.next      


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)