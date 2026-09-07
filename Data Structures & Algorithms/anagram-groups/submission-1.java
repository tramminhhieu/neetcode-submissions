class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] counts = new int[26];
            for(char c : s.toCharArray()){
                counts[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int num : counts){
                keyBuilder.append(num).append('#');
            }
            String key = keyBuilder.toString();
            List<String> group;
            if(map.containsKey(key)){
                group = map.get(key);
            }else{
                group = new ArrayList<>();
            }
            group.add(s);
            map.put(key, group);
        }
        return new ArrayList(map.values());
    }
}
