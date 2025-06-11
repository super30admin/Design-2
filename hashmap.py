#Time complexity Push,pop,peek -O(1)
# Space complexity - O(k) k = No of ele in list

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets=[[] for _ in range(self.size)]

    def _hash(self,key):
        return key% self.size

    def put(self, key: int, value: int) -> None:
        h = self._hash(key)
        for i,(k,v) in enumerate(self.buckets[h]):
            if k==key:
                self.buckets[h][i] = (key,value)
                return
        self.buckets[h].append((key,value))

    def get(self, key: int) -> int:
        h = self._hash(key)
        for k,v in self.buckets[h]:
            if k ==key:
                return v
        return -1

    def remove(self, key: int) -> None:
        h = self._hash(key)
        self.buckets[h] = [(k,v) for k,v in self.buckets[h] if k!= key]