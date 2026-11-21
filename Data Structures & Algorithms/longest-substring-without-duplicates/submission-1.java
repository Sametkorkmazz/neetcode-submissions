class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            maxLength = Math.max(maxLength, r - l + 1);
            set.add(s.charAt(r++));
        }
        return maxLength;
    }
}
