class MyHashMap {
	LinkedList<MapValues>[] map;
	public static int SIZE = 769;

	public MyHashMap() {
		map = new LinkedList[SIZE];
	}

	public void put(int key, int value) {
		int bucket = key % SIZE;
		if (map[bucket] == null) {
			map[bucket] = new LinkedList<MapValues>();
			map[bucket].add(new MapValues(key, value));
		} else {
			for (MapValues mapValue : map[bucket]) {
				if (mapValue.key == key) {
					mapValue.value = value;
					return;
				}
			}
			map[bucket].add(new MapValues(key, value));
		}
	}

	public int get(int key) {
		int bucket = key % SIZE;
		LinkedList<MapValues> values = map[bucket];
		if (values == null)
			return -1;
		for (MapValues mapValue : values) {
			if (mapValue.key == key)
				return mapValue.value;
		}
		return -1;
	}

	public void remove(int key) {
		int bucket = key % SIZE;
		MapValues toRemove = null;
		if (map[bucket] == null)
			return;
		else {
			for (MapValues mapValue : map[bucket]) {
				if (mapValue.key == key) {
					toRemove = mapValue;
				}
			}
			if (toRemove == null)
				return;
			map[bucket].remove(toRemove);
		}
	}

	class MapValues {
		public int key;
		public int value;

		public MapValues(int key, int val) {
			this.key = key;
			this.value = val;
		}
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
