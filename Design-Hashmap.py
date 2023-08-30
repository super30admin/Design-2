# Time Complexity - put - O(1), get - O(N), remove - O(N), hashcode - O(1), search - O(N)
# Space Complexity - O(N)

class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.size = 1001
        self.nodes = [Node(-1, 1) for _ in range(self.size)]

    def put(self, key: int, value: int) -> None:
        parent, target = self._search_node(key)
        
        if target:
            target.value = value 
        else:
            parent.next = Node(key, value)

    def get(self, key: int) -> int:
        parent, target = self._search_node(key)
        return target.value if target else -1

    def remove(self, key: int) -> None:
        parent, target = self._search_node(key)
        if target:
            parent.next = target.next

    def _hashcode(self, key: int):
        return key % self.size

    def _search_node(self, key: int):
        code = self._hashcode(key)
        parent = self.nodes[code]

        while parent and parent.next:
            if parent.next.key == key:
                return parent, parent.next
            
            parent = parent.next
        
        return parent, parent.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)