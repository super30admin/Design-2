# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)


Approach:

we used two stacks in Amortized O(1) run time 

1) Created two empty stacks
2) instack , outstack
3) push all the elements into instack till we encounter pop operation
4) push all the elements from instack to outstack and do pop from outatck and push elements into  instack 
5) when peek comes take top element from outstack if exists else transfer all the elemensta from instack to outstack again


## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)

linear chaining approach 

1) we need an array of 10000 elements starting 0 to 9999
2) when  none do add a node with -1,-1 because when we need to remove head element 
3) if node exists than do traverse the linkedlist and get the prev node which helps use in removing the element by specifying the prev.next = prev.next.next 






