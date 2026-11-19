class TimeMap {
    Map<String, List<List<String>>> map = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        map.merge(
            key, new ArrayList<>(List.of(List.of(String.valueOf(timestamp), value))), (a, b) -> {
                a.add(new ArrayList<>(List.of(String.valueOf(timestamp), value)));
                return a;
            });
    }

    public String get(String key, int timestamp) {
        String result = "";
        List<List<String>> timeMap = map.getOrDefault(key, new ArrayList<>());
        int l = 0, r = timeMap.size() - 1;
        int index = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (Integer.parseInt(timeMap.get(m).get(0)) == timestamp) {
                return timeMap.get(m).get(1);
            }
            if (Integer.parseInt(timeMap.get(m).get(0)) > timestamp) {
                r = m - 1;
            } else {
                result = timeMap.get(m).get(1);
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