class MyHashSet(object):

	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.hashSet = [None] * 100
		self.buckets = 100
		self.bucketItems = 100

	def add(self, key):
		"""
		:type key: int
		:rtype: None
		"""
		i = self.hashfunc1(key)
		if self.hashSet[i] == None:
			self.hashSet[i] = [None] * self.bucketItems
		j = self.hashfunc2(key)
		self.hashSet[i][j] = True

	def remove(self, key):
		"""
		:type key: int
		:rtype: None
		"""
		i = self.hashfunc1(key)
		if self.hashSet[i] == None:
			return
		j = self.hashfunc2(key)
		self.hashSet[i][j] = False

	def contains(self, key):
		"""
		Returns true if this set contains the specified element
		:type key: int
		:rtype: bool
		"""
		i = self.hashfunc1(key)
		j = self.hashfunc2(key)
		return self.hashSet[i] != None and self.hashSet[i][j]

	def hashfunc1(self, value):
		return value % self.buckets

	def hashfunc2(self, value):
		return value // self.bucketItems

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