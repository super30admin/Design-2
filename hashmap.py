# Time: O(N/K) where N is size of hashmap and k is no. of buckets. k is 10000
# space: O(K + N)
# did code run successfully: yes
# issues faced: case of putting in last node of linkedlist
# approach: using a static array of size 10000 for hash table, linkedlist is used for each bucket.
# using a BST would have given log(n/k) time.

class Node:
    def __init__(self, key = -1, val = -1):
        self.key = key
        self.value = val
        self.next = None
        
class MyHashMap:

    def __init__(self):
        self.hashtable = [Node() for _ in range(10**4)]

    def put(self, key: int, value: int) -> None:
        head = self.hashtable[key % 10**4]
        while head.next:
            if head.key == key:
                head.value = value
                return
            head = head.next
        if head.key == key:
                head.value = value
                return
        head.next = Node(key, value)
        return
            
    def get(self, key: int) -> int:
        head = self.hashtable[key % 10**4]
        while head:
            if head.key == key:
                return head.value
            head = head.next
        return -1

    def remove(self, key: int) -> None:
        head = self.hashtable[key % 10**4]
        while head.next:
            if head.next.key == key:
                head.next = head.next.next
                return
            head = head.next
        return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)