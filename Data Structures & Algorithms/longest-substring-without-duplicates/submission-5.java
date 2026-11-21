class Solution {
    public int lengthOfLongestSubstring(String s) {
     int l = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                map.merge(s.charAt(l++), -1, Integer::sum);
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
