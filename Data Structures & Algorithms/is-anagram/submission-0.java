class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
          char[] charsT = t.toCharArray();
        Arrays.sort(charsT);

        return new String(charsS).equals(new String(charsT));
    }
}