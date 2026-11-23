class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int max = 0;
        int maxF = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.merge(c, 1, Integer::sum);
            maxF = Math.max(maxF, map.get(c));
            while ((r - l + 1) - maxF > k) {
                char left = s.charAt(l++);
                map.compute(left, (key, v) -> v - 1);
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
