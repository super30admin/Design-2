// Time Complexity : empty() - O(1), push() - O(1), pop()- worst-O(n), avg O(1), peek - worst -O(n), avg - O(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem

class MyQueue() {
    //    Initialize two stacks, one for adding and another for pop and peek.
    var inStack: MutableList<Int> = mutableListOf()
    var outStack: MutableList<Int> = mutableListOf()

    //    we will push the element into the inStack - takes O(1)
    fun push(x: Int) {

        inStack.add(x)

    }

    //    if outStack is not empty we will pop from outStack else we will push all the elements in inStack to outStack by inStack.pop and return pop of the outStack
    fun pop(): Int {
        if (!outStack.isEmpty()) {
            return outStack.removeAt(outStack.size - 1)
        }
        while (!inStack.isEmpty()) {
            outStack.add(inStack.removeAt(inStack.size - 1))
        }

        return outStack.removeAt(outStack.size - 1)
    }

//    if outStack is not empty we will return last element from outStack else we will push all the elements in inStack to outStack by inStack.pop and return last element of the outStack

    fun peek(): Int {
        if (!outStack.isEmpty()) {
            return outStack.get(outStack.size - 1)
        }
        while (!inStack.isEmpty()) {
            outStack.add(inStack.removeAt(inStack.size - 1))
        }

        return outStack.get(outStack.size - 1)
    }

    //    we will just check if both the stack lengths are 0, if it is then return true, else false.
    fun empty(): Boolean {

        return inStack.isEmpty() && outStack.isEmpty()

    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */