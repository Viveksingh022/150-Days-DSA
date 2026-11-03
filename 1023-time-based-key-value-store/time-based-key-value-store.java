
class TimeMap {

    HashMap<String, List<Integer>> timestamps;
    HashMap<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        timestamps.putIfAbsent(key, new ArrayList<>());
        values.putIfAbsent(key, new ArrayList<>());

        timestamps.get(key).add(timestamp);
        values.get(key).add(value);
    }

    public String get(String key, int timestamp) {

        if (!timestamps.containsKey(key)) {
            return "";
        }

        List<Integer> list = timestamps.get(key);
        List<String> vals = values.get(key);

        int low = 0;
        int high = list.size() - 1;
        String ans = "";

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) <= timestamp) {
                ans = vals.get(mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */