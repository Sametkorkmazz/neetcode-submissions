class TimeMap {
    record Entry(int timestamp, String value) {}

    Map<String, List<Entry>> map = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = map.get(key);
        if (entries == null)
            return "";
        int l = 0, r = entries.size() - 1;
        String result = "";
        while (l <= r) {
            int m = (l + r) / 2;
            Entry e = entries.get(m);
            if (e.timestamp() == timestamp) {
                return e.value();
            }
            if (e.timestamp() > timestamp) {
                r = m - 1;
            } else {
                result = e.value();
                l = m + 1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */