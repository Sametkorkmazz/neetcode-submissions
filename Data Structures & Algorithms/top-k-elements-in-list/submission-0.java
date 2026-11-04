class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> ans = new HashMap<>();
        for(int num : nums){
            ans.merge(num, 1, Integer::sum);
        }

        List<Map.Entry<Integer,Integer>> sortedList = new ArrayList(ans.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());
        int[] answer = new int[k];

        for(int i = 0; i < k; i++){
            answer[i] = sortedList.get(sortedList.size() - i -1).getKey();
        }
        return answer;
    }
}
