class MyHashMap:

    def __init__(self):
        self.size=1000
        self.buckets=[[] for _ in range(self.size)]

    def _hash(self,key):
        return key % self.size
    
    def put(self,key,value):
        index=self._hash(key)
        for i,(k,v) in enumerate(self.buckets[index]):
            if k==key:
                self.buckets[index][i]=(key,value)
                return
        self.buckets[index].append((key,value))

    def get(self,key):
        index=self._hash(key)
        for(k,v) in self.buckets[index]:
            if k==key:
                return v
        return -1
        
    def remove(self,key):
        index=self._hash(key)
        self.buckets[index]=[(k,v)for(k,v)in self.buckets[index]if k!=key]

commands=["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
values=[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]

output=[]
my_hash_map=None

for cmd,val in zip(commands,values):
    if cmd=="MyHashMap":
        my_hash_map=MyHashMap()
        output.append(None)
    elif cmd =="put":
        my_hash_map.put(val[0],val[1])
        output.append(None)
    elif cmd =="get":
        result=my_hash_map.get(val[0])
        output.append(result)
    elif cmd=="remove":
        my_hash_map.remove(val[0])
        output.append(None)

print(output)