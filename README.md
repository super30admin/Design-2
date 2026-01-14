# Design-2

Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
Use 2 stacks instack & outstack
For peep() and pop() - if outstack is empty, then util the instack is empty try pushing values from instack to outstack then pop element from outstack.

## Problem 2:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
we are using an storage array of Node w 10,000  and Linkedlist of 100 so traveling linkedlist gets faster.
create a find function with 2 pointers prev,curr that iterates over the linkedlist to search for the key and return the prev Node.
put() has 2 scenarios - if key already exists or create fresh Node, delete() - if key does not exist or if it is in middle.



