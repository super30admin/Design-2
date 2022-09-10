# -*- coding: utf-8 -*-
"""Hashmap.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1-Bw8kTq67qgWqfIdsDDj8ekUTaSqfnZ7
"""

class Node:

  def __init__(self, key, value):
    self.key = key
    self.value = value
    self.next = None

class MyHashMap:

    def __init__(self):
      self.k = 10000
      self.arr = [None] * self.k        

    def put(self, key: int, value: int) -> None:
      index = key % self.k
      if self.arr[index] == None:
        root = Node(key=key, value=value)
        self.arr[index] = root
      else:
        prev = None
        root = self.arr[index]
        while root:
          if root.key == key:
            root.value = value
            return
          prev = root
          root = root.next
        prev.next = Node(key=key, value=value)
        

    def get(self, key: int) -> int:
        index = key % self.k

        if self.arr[index] == None:
            return -1
        
        else:

            root = self.arr[index]
            while root:
                if root.key == key:
                    return root.value
                root = root.next
        
        return -1
        

    def remove(self, key: int) -> None:
        index = key % self.k
        
        if self.arr[index] == None:
            return

        root = self.arr[index]
        
        if root.key == key:
            self.arr[index] = root.next
        else:

            prev = root
            currNode = root.next
            
            while currNode:

                if currNode.key == key:

                    prev.next = prev.next.next
                    return
                    
                prev = currNode
                currNode = currNode.next
        
        return -1
        


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,11)
param_2 = obj.get(1)
obj.remove(1)