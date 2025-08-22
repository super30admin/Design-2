// Time Complexity, Amortized - O(1), worst case - O(n), where n is  number os element inserted elements
// Space Complexity: O(n), where n is size of queue - number of inserted elements
class MyQueue {
	private in: Stack;
	private out: Stack;
	constructor() {
		this.in = new Stack();
		this.out = new Stack();
	}

	push(x: number): void {
		this.in.push(x);
	}

	pop(): number {
		this.peek();
		return this.out.pop();
	}

	peek(): number {
		if (this.out.isEmpty()) {
			while (!this.in.isEmpty()) {
				const poppedElement = this.in.pop();
				this.out.push(poppedElement);
			}
		}

		return this.out.peek();
	}

	empty(): boolean {
		return this.in.isEmpty() && this.out.isEmpty();
	}
}

class Stack {
	private stack: number[];

	constructor() {
		this.stack = [];
	}

	push(val: number): void {
		this.stack.push(val);
	}

	isEmpty(): boolean {
		return this.stack.length === 0;
	}
	pop(): number | null {
		if (this.isEmpty()) return;
		return this.stack.pop();
	}

	peek(): number | null {
		if (this.isEmpty()) return;
		return this.stack[this.stack.length - 1];
	}
}
