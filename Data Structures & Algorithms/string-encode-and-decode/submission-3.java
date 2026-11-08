class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int curr = 0;
        List<String> result = new ArrayList();

        while (curr < str.length()) {
            char read = str.charAt(curr);
            String lengthStr = "";

            while (read != '#') {
                lengthStr += read;
                read = str.charAt(++curr);
            }
            int length = Integer.parseInt(lengthStr);
            curr++;
            String word = str.substring(curr, curr + length);
            curr += length;
            result.add(word);
        }
        return result;
    }
}
