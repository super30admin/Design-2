// Time Complexity :  O(1) on avg some times O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// line 41 missed to check both stack when checking for isEmpty
import java.util.*

class MyQueue() {
    val inStack: Stack<Int> = Stack<Int>()
    val outStack:Stack<Int> = Stack<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        if(outStack.isNotEmpty()) return outStack.pop()

        if(inStack.isEmpty()) return Int.MAX_VALUE

        while(inStack.isNotEmpty()){
            outStack.push(inStack.pop())
        }
        return outStack.pop()
    }

    fun peek(): Int {
        if(outStack.isNotEmpty()) return outStack.peek()

        //if inStack isEmpty
        if(inStack.isEmpty()) return Int.MAX_VALUE

        while(inStack.isNotEmpty()){
            outStack.push(inStack.pop())
        }

        return outStack.peek()
    }

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