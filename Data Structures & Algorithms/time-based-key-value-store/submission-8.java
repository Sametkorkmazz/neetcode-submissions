class TimeMap {
    record Entry(String value, int timestamp) {}

    Map<String, List<Entry>> times = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        times.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = times.getOrDefault(key, new ArrayList<>());

        int l = 0, r = entries.size() - 1;
        String ans  = "";
        while (l <= r) {
            int m = (l + r) / 2;
            Entry entry = entries.get(m);
            if (entry.timestamp() == timestamp) {
                return entry.value();
            }

            if (entry.timestamp() > timestamp) {
                r = m - 1;
            } else {
                l = m + 1;
                ans = entry.value();
            }
        }
        return ans;
    }
}
