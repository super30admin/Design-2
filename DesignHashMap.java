import java.util.Arrays;

// T.C -> O(1)
// S.C -> O(1) put,get,remove functions
// Solved on Leetcode: Yes

public class DesignHashMap {
    int[] valArr;

    public DesignHashMap() {
        valArr = new int[1000001];
        Arrays.fill(valArr, -1);
    }

    public void put(int key, int value) {
        valArr[key] = value;
    }

    public int get(int key) {
        if (valArr[key] == -1) {
            return -1;
        } else {
            return valArr[key];
        }

    }

    public void remove(int key) {
        valArr[key] = -1;
    }
}