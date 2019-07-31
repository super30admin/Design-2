class MyHashSet(object):

	class Node(object):
		"""docstring for Node"""
		def __init__(self, key):
			self.key = key
			self.next = None

	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.hashSet = [None] * 10000

	def add(self, key):
		"""
		:type key: int
		:rtype: None
		"""
		i = self.find_index(key)
		if self.hashSet[i] == None:
			self.hashSet[i] = self.Node(-1)
		prev_node = self.find_node(self.hashSet[i], key)
		if prev_node.next == None:
			prev_node.next = self.Node(key)
		else:
			prev_node.next.key = key

	def remove(self, key):
		"""
		:type key: int
		:rtype: None
		"""
		i = self.find_index(key)
		if self.hashSet[i] == None:
			return
		prev_node = self.find_node(self.hashSet[i], key)
		if prev_node.next == None:
			return None
		else:
			prev_node.next = prev_node.next.next


	def contains(self, key):
		"""
		Returns true if this set contains the specified element
		:type key: int
		:rtype: bool
		"""
		i = self.find_index(key)
		if self.hashSet[i] == None:
			return False
		prev_node = self.find_node(self.hashSet[i], key)
		if prev_node.next == None:
			return False
		else:
			return True

	def find_index(self, key):
		return hash(key) % len(self.hashSet)

	def find_node(self, head, key):
		cur = head
		prev = None
		while cur != None and cur.key != key:
			prev = cur
			cur = cur.next
		return prev

if __name__ == "__main__":
	hashSet = MyHashSet()
	hashSet.add(1)
	hashSet.add(2)
	print(hashSet.contains(1))    # returns true
	print(hashSet.contains(3))    # returns false (not found)
	hashSet.add(2)
	print(hashSet.contains(2))    # returns true
	hashSet.remove(2)
	print(hashSet.contains(2))    # returns false (already removed)