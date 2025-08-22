// Time Complexity, Amortized - O(1), worst case - O(n), where n is number of inserted elements
// Space Complexity: O(n), where n is number of inserted elements
class MyHashMap {
	private storage: Node[];
	private buckets: number;

	constructor() {
		this.buckets = 1000;
		this.storage = new Array(this.buckets);
	}

	getHash(key: number): number {
		return key % this.buckets;
	}

	helper(head: Node, key: number): Node {
		let prev = head;
		let curr = head.next;

		while (curr !== null && curr.key !== key) {
			prev = curr;
			curr = curr.next;
		}

		return prev;
	}

	put(key: number, value: number): void {
		const bucket = this.getHash(key);
		if (!this.storage[bucket]) {
			const newNode = new Node(-1, -1);
			this.storage[bucket] = newNode;
		}

		// get previous node
		let prev = this.helper(this.storage[bucket], key);

		// update the value if key already exists
		if (prev.next !== null) {
			prev.next.value = value;
		} else {
			// append a new node
			prev.next = new Node(key, value);
		}
	}

	get(key: number): number {
		const bucket = this.getHash(key);
		if (!this.storage[bucket]) return -1;

		let prev = this.helper(this.storage[bucket], key);

		// return the value if key already exists
		if (prev.next !== null) {
			return prev.next.value;
		} else {
			return -1;
		}
	}

	remove(key: number): void {
		const bucket = this.getHash(key);
		if (!this.storage[bucket]) return;

		let prev = this.helper(this.storage[bucket], key);

		if (prev.next !== null) {
			let curr = prev.next;
			prev.next = curr.next;
			curr.next = null;
		}
	}
}

class Node {
	public key: number;
	public value: number;
	public next: Node | null;

	constructor(key: number, value: number) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
