import java.util.*;

class SnapshotArray {

    private TreeMap<Integer, Integer>[] snaps;
    private int snapId = 0;

    public SnapshotArray(int length) {

        snaps = new TreeMap[length];

        for (int i = 0; i < length; i++) {
            snaps[i] = new TreeMap<>();

            // Initially value is 0
            snaps[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        snaps[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {

        // snap_id se chhota ya equal closest key
        int key = snaps[index].floorKey(snap_id);

        return snaps[index].get(key);
    }
}