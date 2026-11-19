class TimeMap {
    record Entry(int timestamp, String value) {}

    Map<String, List<Entry>> map = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String result = "";
        List<Entry> timeMap = map.getOrDefault(key, new ArrayList<>());
        int l = 0, r = timeMap.size() - 1;
        int index = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (timeMap.get(m).timestamp() == timestamp) {
                return timeMap.get(m).value();
            }
            if (timeMap.get(m).timestamp() > timestamp) {
                r = m - 1;
            } else {
                result = timeMap.get(m).value();
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