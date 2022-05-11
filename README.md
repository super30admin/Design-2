# Design-2

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

Approach:

pushStack = []
popStack = []

1. For PUSH(), append the elements into pushStack
2. For POP(), conditional
	2.1. If popStack is empty, pop all the elements from the pushStack and append them in popStack
	2.2. Else , just POP the element from the popStack
3. For PEAK(), conditional
	3.1. If popStack is empty, pop all the elements from the pushStack and append them in popStack, return popStack[-1]
	3.2. Else , just return popStack[-1]
4. For IS_EMPTY(), check if both pushStack and popStack is empty

## Problem 2:(https://leetcode.com/problems/design-hashset/)
Check design-1 problem. Already implemented



