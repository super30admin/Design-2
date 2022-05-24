class MyQueue {
    addStack = [];
    removeStack = [];

    push(x: number): void {
        this.addStack.push(x);
    }

    pop(): number {
        if(!this.removeStack.length){
            while(this.addStack.length){
                this.removeStack.push(this.addStack.pop());
            }
        }
        return this.removeStack.pop();
    }

    peek(): number {
        if(!this.removeStack.length){
            while(this.addStack.length){
                this.removeStack.push(this.addStack.pop());
            }
        }
        return this.removeStack[this.removeStack.length - 1];
    }

    empty(): boolean {
        return !this.addStack.length && !this.removeStack.length;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */