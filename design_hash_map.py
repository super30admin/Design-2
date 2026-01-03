class MyHashMap:
  def __init__(self):
    self.primary_buckets = 1000
    self.secondary_buckets = 1001
    self.storage =[None for i in range(self.primary_buckets)]

  def primary_hash(self, key:int)->int:
    return key%self.primary_buckets

  def secondary_hash(self, key:int)->int:
    return key//self.primary_buckets


  def put(self, key:int, value:int)->None:
    primary_key = self.primary_hash(key)

    if self.storage[primary_key] == None:
      self.storage[primary_key] = [None for i in range(self.secondary_buckets)]
      secondary_key = self.secondary_hash(key)
      self.storage[primary_key][secondary_key] = value

    else:
      self.storage[primary_key][self.secondary_hash(key)]= value


  def get(self, key:int)->int:
    primary_key = self.primary_hash(key)

    if self.storage[primary_key]== None or self.storage[primary_key][self.secondary_hash(key)] == None:
      return -1
    else:
      return self.storage[primary_key][self.secondary_hash(key)]

  def remove(self, key:int)->None:
    primary_key = self.primary_hash(key)

    if self.storage[primary_key]== None:
        return
    else:
      self.storage[primary_key][self.secondary_hash(key)] = None


