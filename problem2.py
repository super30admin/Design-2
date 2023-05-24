#Time Complexity : O(n) ... n is number of elements 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : initially I was planning to use a list of tuples which caused some issues and therefore I decided to use a list of lists


#Your code here along with comments explaining your approach
#I am using a list of lists of key value pairs in the form - [[1,2],[5,3]]. For the put function, I am simply checking the first element of all the nested lists to search for the key and adding new key when it doesn't exists. For get function, I am iterating pver the nested lists of pairs. For remove, I am iterting over and keeping track of the index for the pair which has to be removed and later popping it out.

class MyHashMap:

    def __init__(self):
        self.hM = []
        
    def put(self, key: int, value: int) -> None:
        present = 0
        if self.hM:
            for i,pair in enumerate(self.hM):
                if pair[0] == key:
                    self.hM[i] = [key,value]
                    present = 1
            
            if present == 0:
                self.hM.append([key,value])
        else:
            self.hM.append([key,value])

    def get(self, key: int) -> int:
        if self.hM:
            for i,pair in enumerate(self.hM):
                if pair[0] == key:
                    return pair[1]
            return -1

        else:
            return -1

    def remove(self, key: int) -> None:
        ele_to_remove_idx = -1
        if self.hM:
            for i,pair in enumerate(self.hM):
                if pair[0] == key:
                    ele_to_remove_idx = i
                    break

            if ele_to_remove_idx == -1:
                return 
            else:
                self.hM.pop(ele_to_remove_idx)
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)