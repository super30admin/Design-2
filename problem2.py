# Time Complexity : O(1)
# Space Complexity : O(n) where n is the number of key-value pairs stored in the dictionary
# Yes, the code ran successfully on leetcode
# I did not face any problem while coding this problem

#Here I am going to implement hashmap using dictionary
class MyHashMap(object):

    def __init__(self):
        #initializing the dictionary
        self.dictionary={}

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        #inserting value into dictinary for corresponding key
        #and updating the value if the coreesponding value already present in the dictionary
        self.dictionary[key]=value       

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        #if the key is present in dictionary, it will return the corresponding value
        if(key in self.dictionary):
            return self.dictionary.get(key)
        #if the key is not present, it will return -1
        else:
            return -1      

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        #if the key is present in the dictionary, it will delete corresponding key and value
        if(key in self.dictionary):
            del self.dictionary[key]

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)