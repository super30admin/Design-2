//Time Complexity O(1), for pop it would O(n) worst case
//Space Complexity O(n) 
class MyQueue() {

    private val s1 = java.util.Stack<Int>()
    private val s2 = java.util.Stack<Int>()
    fun push(x: Int) {
        s1.push(x)
    }

    fun pop(): Int {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop())
            }
        }
            return s2.pop()
    }

    fun peek(): Int {
        if(!s2.isEmpty()) {
            return s2.peek()
        } else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop())
            }
        }
        return s2.peek()
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
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