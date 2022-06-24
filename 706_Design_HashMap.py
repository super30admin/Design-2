'''

## Problem 4: Design HashMap (https://leetcode.com/problems/design-hashmap/)

## Author: Neha Doiphode
## Date  : 06-22-2022

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

    MyHashMap() initializes the object with an empty map.
    void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
    int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]



Constraints:

    0 <= key, value <= 106
    At most 104 calls will be made to put, get, and remove.

Time complexity:
    O(n) - Please refer to doc-strings for each method in the class below.

Space complexity:
    O(k + m) - k = Number of predefined buckets.
               m = number of unique keys inserted into the map.
'''

class Node:
    def __init__(self, key=None, value=None, next=None):
        self.key = key
        self.value = value
        self.next = next

class MyHashMap:

    def __init__(self):
        self.buckets = 10000 # 10^4, having longer primary array gives us direct access to elements. Also, we can have shorter secondary linked lists/chains to save traverse times.
        self._head_nodes = [None] * self.buckets

    def get_bucket(self, key) -> int:
        '''
        Time complexity: O(1)
        '''
        return key % self.buckets

    def find_node(self, head, key) -> Node:
        '''
        Time complexity: O(n), where n is number of nodes present in the linked list.
        '''
        previous = head
        current  = head.next

        while current and current.key != key:
            previous = current
            current = current.next

        return previous

    def put(self, key: int, value: int) -> None:
        '''
        Time complexity: O(1) for choosing the right bucket.
                         O(n) for traversing the linked list if present. If yes, to find the last node.(worst case)
                         O(1) to add new node at the end.

                         ~= O(1) + O(n) + O(1) ~= O(n) as asymptotic.
        '''
        bucket_index = self.get_bucket(key)
        if self._head_nodes[bucket_index] == None:
            self._head_nodes[bucket_index] = Node(-1, -1)

        previous = self.find_node(self._head_nodes[bucket_index], key)
        if previous.next == None:
            previous.next = Node(key, value)
        else:
            previous.next.value = value

    def get(self, key: int) -> int:
        '''
        Time complexity: O(1) for choosing the right bucket.
                         O(n) for traversing the linked list if present to find the right node.(worst case)
                         ~= O(1) + O(n) ~= O(n) as asymptotic.
        '''
        bucket_index = self.get_bucket(key)
        if self._head_nodes[bucket_index] == None:
            return -1

        previous = self.find_node(self._head_nodes[bucket_index], key)
        if previous.next:
            return previous.next.value
        else:
            return -1

    def remove(self, key: int) -> None:
        '''
        Time complexity: O(1) for choosing the right bucket.
                         O(n) for traversing the linked list if present. If yes, to find the node previous to the node to be removed.(worst case)
                         O(1) Adjusting linked list pointers so that chaining is maintained after the desired node removal.

                         ~= O(1) + O(n) + O(1) ~= O(n) as asymptotic.
        '''
        bucket_index = self.get_bucket(key)
        if self._head_nodes[bucket_index] == None:
            return

        previous = self.find_node(self._head_nodes[bucket_index], key)
        if previous.next == None:
            return
        previous.next = previous.next.next

    def display(self):
        print()
        print('Current hash map: ')
        for node in self._head_nodes:
            current = node
            if current != None:
                if current.next != None:
                    print(f'Bucket: {self.get_bucket(current.next.key)}: ', end = '')
                while current.next:
                    if current.key != -1:
                        print(f'[key: {current.key} , value: {current.value}] -> ', end = '')
                    current = current.next
                print(f'[key: {current.key} , value: {current.value}]')
        print()



# Driver code
hash_map = MyHashMap()
print('Put(key, value): 10000, 1')
hash_map.put(10000, 1)
print('Put(key, value): 20000, 2')
hash_map.put(20000, 2)
hash_map.display()
value = hash_map.get(10000)
print(f'Get(key): Get 10000: {value}')
value = hash_map.get(30000)
print(f'Get(key): Get 30000: {value}')
print('Put(key, value): 20003, 1')
print('Put(key, value): 30003, 1')
print('Put(key, value): 40003, 1')
hash_map.put(20003, 1)
hash_map.put(30003, 1)
hash_map.put(40003, 1)
hash_map.display()
value = hash_map.get(20003)
print(f'Get(key): Get 20003: {value}')
print('Remove(key): Remove 30003')
hash_map.remove(30003)
hash_map.display()
value = hash_map.get(30003)
print(f'Get(value): Get 30003: {value}')
