class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.merge(c, 1, Integer::sum);
            int maxF = getMaxF(map.values());
            while ((r - l + 1) - maxF > k) {
                c = s.charAt(l++);
                map.compute(c, (key, v) -> v - 1);
                maxF = getMaxF(map.values());
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public int getMaxF(Collection<Integer> values) {
        int max = Integer.MIN_VALUE;
        for (int num : values) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
