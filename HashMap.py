# Time Complexity: O(1)- amortized
# Space Complexity: O(n)
# Created an empty dictionary
# check if is key already present in all functions(put,get,remove)
    # put: if not create a key value pair, else update the value
    # get : if not return 1 , else return the value of key
    # remove: if present remove the key and value

class MyHashMap:

    def __init__(self):
        self.Empty_map = {}

    def put(self, key: int, value: int) -> None:    #O(1)- amortized
        if key in self.Empty_map:
            self.Empty_map[key] = value
        else:
            self.Empty_map[key] = value


    def get(self, key: int) -> int:         #O(1)- amortized
        if key in self.Empty_map:
            return self.Empty_map[key]
        else:
            return -1

    def remove(self, key: int) -> None:         #O(1)- amortized
        if key in self.Empty_map:
            del self.Empty_map[key]
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)