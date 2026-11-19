class TimeMap {

    Map<String, List<List<String>>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        map.merge(key, new ArrayList<>(List.of(List.of(String.valueOf(timestamp), value))), (a, b) -> {
            a.add(new ArrayList<>(List.of(String.valueOf(timestamp), value)));
            return a;
        });
    }

    public String get(String key, int timestamp) {
        List<List<String>> timeMap = map.get(key);
        if (timeMap == null) {
            return "";
        }
        if (Integer.parseInt(timeMap.getFirst().get(0)) > timestamp) {
            return "";
        }
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
                index = Math.max(index, m);
                l = m + 1;
            }
        }
        return timeMap.get(index).get(1);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */