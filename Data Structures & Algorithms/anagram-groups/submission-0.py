class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        my_map = {}
        for x in range(len(strs)):
            word = "".join(sorted(strs[x]))
            my_list = my_map.get(word, [])
            my_list.append(x)
            my_map[word] = my_list
        
        result =[]
        for word in my_map:
            indexes = my_map[word]
            sub_list = []
            for i in indexes:
                sub_list.append(strs[i])
            result.append(sub_list)
        return result

