class Solution {

    public String encode(List<String> strs) {
        StringBuilder strBuilder = new StringBuilder();
        for(String str: strs) {
            strBuilder.append(str.length()).append("#").append(str);
        }
        return strBuilder.toString();
    }

    public List<String> decode(String str) {
       int index = 0;
       List<String> result = new ArrayList<>();
       while(index < str.length()){
        int j = index;
        while(str.charAt(j) != '#'){
            j++;
        }
        int length = Integer.parseInt(str.substring(index, j));
        index = j+1;
        j = index + length;
        String word = str.substring(index, j);
        result.add(word);
        index = j;
       }
       return result;
    }
}
