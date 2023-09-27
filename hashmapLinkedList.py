class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap(object):

    def __init__(self):
        self.hashMap = [None] * 1009

    def hashFunc(self, key):
        return key % len(self.hashMap)

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.hashFunc(key)
        if not self.hashMap[index]:
            self.hashMap[index] = Node(key, value)
        else:
            node = self.hashMap[index]
            curr = None
            while node:
                if node.key == key:
                    node.val = value
                    return
                curr = node
                node = node.next
            curr.next = Node(key, value)

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self.hashFunc(key)
        if self.hashMap[index]:
            node = self.hashMap[index]
            while node:
                if node.key == key:
                    return node.val
                node = node.next
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashFunc(key)
        if self.hashMap[index]:
            node = self.hashMap[index]
            curr = None
            while node:
                if node.key == key:
                    if curr:
                        curr.next = node.next
                    else:
                        self.hashMap[index] = node.next
                curr = node
                node = node.next

            # Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)