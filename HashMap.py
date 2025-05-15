# Time Complexity: O(1) for all the methods
# Space Complexity: O(n + m), n is the no.of nodes and m is the no.of buckets
# Did this code successfully run on Leetcode: Yes


# Your code here along with comments explaining your approach
# hash map with linear chaining
# hash map is initialized with 10^4 buckets and each bucket at max has 100 nodes


class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap(object):

    def __init__(self):
        self.buckets = 10000
        self.hash_map = [None] * self.buckets
    
    def hash_function(self, key):
        return key % self.buckets

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        hash_index = self.hash_function(key)

        if self.hash_map[hash_index]:
            prev = self.hash_map[hash_index]
            current = prev.next
            while current:
                # if key alreay exists update the value
                if current.key == key:
                    current.value = value
                    return
                else:
                    # go to next node
                    prev = current
                    current = current.next
            
            # add the key as a last node
            new_node = Node(key, value)
            prev.next = new_node
            
        else:
            # create a dummy node and place that node in the index
            dummy_node = Node("dummy", "dummy")
            self.hash_map[hash_index] = dummy_node

            new_node = Node(key, value)
            dummy_node.next = new_node  

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        hash_index = self.hash_function(key)

        if self.hash_map[hash_index]:
            dummy_node = self.hash_map[hash_index]
            prev = dummy_node
            current = prev.next

            while current:
                if current.key == key:
                    return current.value
                else:
                    prev = current
                    current = current.next
            
        return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash_index = self.hash_function(key)

        if self.hash_map[hash_index]:
            dummy_node = self.hash_map[hash_index]
            prev = dummy_node
            current = prev.next

            while current:
                if current.key == key:
                    prev.next = current.next
                    current.next = None
                    return
                
                prev = current
                current = current.next


        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)