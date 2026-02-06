//Time complexity: O(1) amortized for each operation
//Space complexity: O(n) where n is the number of elements in the queue

class QueueStack() {

    private var inStack = mutableListOf<Int>()
    private var outStack = mutableListOf<Int>()

    fun push(x: Int) {
        inStack.add(x)
    }

    fun pop(): Int {
        if (outStack.isNotEmpty()) {
            return outStack.removeAt(outStack.size - 1)
        }
        while (inStack.isNotEmpty()) {
            outStack.add(inStack.removeAt(inStack.size - 1))
        }

        return outStack.removeAt(outStack.size - 1)
    }

    fun peek(): Int {
        if (outStack.isNotEmpty()) {
            return outStack[outStack.size - 1]
        }
        while (inStack.isNotEmpty()) {
            outStack.add(inStack.removeAt(inStack.size - 1))
        }

        return outStack[outStack.size - 1]
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