'''
    Design a hashmap
    https://leetcode.com/problems/design-hashmap/description/

    Implement the MyHashMap class:
    MyHashMap() initializes the object with an empty map.
    void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
    int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

    Example 1:
    Input: ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
    [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
    Output:     [null, null, null, 1, -1, null, 1, null, -1]
    Explanation:
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

    Reference:
        https://youtu.be/Sg-alcOkPY4?t=2216
        Trade off between length of linked list in map[i] vs len of map[] (no. of head nodes):
        https://youtu.be/Sg-alcOkPY4?t=2589
        https://youtu.be/Sg-alcOkPY4?t=4802

'''
class NodeKV:
    def __init__(self, k=None, v=None):
        self.k = k
        self.v = v
        self.next = None

class MyHashMap:
    def __init__(self):
        self.len = 1000
        # create a list of head nodes; head node is a dummy node
        # with no information in key and value. Hence, key and value
        # set to None
        self.map = [NodeKV() for i in range(self.len+1)]

    def hash(self, k):
        '''
        convert key to index
        Time: O(1)
        '''
        index = k % self.len
        return index

    def find(self, head, k):
        '''
        find() returns the prev node before the node containing the target key. If key is not present, then prev node points to the last node
        Time: O(L), L = len of linked list
        '''
        prev = head # dummy node
        curr = head.next # first node with data
        while curr is not None and curr.k != k:
            prev = curr
            curr = curr.next
        return prev

    def put(self, k, v):
        '''
        add key to hashmap
        Time: O(L), L = len of linked list
        '''
        index = self.hash(k)
        head = self.map[index]
        prev = self.find(head, k)
        if prev.next is not None:
            # this means key in prev.next node
            prev.next.v = v
        else:
            # this means we reached null because key not found
            prev.next = NodeKV(k, v)

    def get(self, k):
        '''
        get value of key from hashmap
        Time: O(L), L = len of linked list
        '''
        index = self.hash(k)
        head = self.map[index]
        prev = self.find(head, k)
        if prev.next is not None:
            # this means key in prev.next node
            return prev.next.v
        else:
            # this means we reached null because key not found
            return -1

    def remove(self, k):
        '''
        remove key from hashmap
        Time: O(L), L = len of linked list
        '''
        index = self.hash(k)
        head = self.map[index]
        prev = self.find(head, k)
        if prev.next is not None:
           prev.next = prev.next.next


def run_hashmap():
    h = MyHashMap()
    h.put(1, '1') # The map is now [[1,1]]
    h.put(2, '2') # The map is now [[1,1], [2,2]]
    v = h.get(1); print(v)   # return 1, The map is now [[1,1], [2,2]]
    v = h.get(2); print(v)   # return 2
    v = h.get(3); print(v)   # return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    h.put(2, '1') # The map is now [[1,1], [2,1]] (i.e., update the existing value)
    v = h.get(2); print(v)   # return 1, The map is now [[1,1], [2,1]]
    h.remove(2) # remove the mapping for 2, The map is now [[1,1]]
    v = h.get(2); print(v)    # return -1 (i.e., not found), The map is now [[1,1]]
    h.put(2, '2') # map is now [[1,1], [2,2]]
    h.put(1002, '1002') # map is now [[1,1], [[2,2], [1002, 1002]]]
    h.put(2002, '2002') # map is now [[1,1], [[2,2], [1002,1002], [2002, 2002]]]
    v = h.get(2002); print(v) # return 2002
    v = h.get(3002); print(v) # return -1
    h.remove(2002) # map is now [[1,1], [[2,2], [1002, 1002]]]
    v = h.get(2002); print(v) # return -1

run_hashmap()