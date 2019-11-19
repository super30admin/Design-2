class MyHashSet(object):

    def __init__(self):
        self.items = set()

    def add(self, key: int) -> None:
        self.items.add(key)
        print("set after adding",self.items)

    def remove(self, key: int) -> None:
        if key in self.items:
            self.items.remove(key)
            print('set after removing',self.items)
        else:
            print("Failed to remove: key not in set")
            pass

    def contains(self, key: int) -> bool:
        if key in self.items:
            print('True')
        else:
            print('False')

h = MyHashSet()
h.add(1)
h.add(2)
h.add(3)
h.add(4)
h.add(5)
h.remove(1)
h.remove(0)
h.contains(2)
h.contains(0)

'''
# output

set after adding {1}
set after adding {1, 2}
set after adding {1, 2, 3}
set after adding {1, 2, 3, 4}
set after adding {1, 2, 3, 4, 5}
set after removing {2, 3, 4, 5}
Failed to remove: key not in set
True
False
'''
