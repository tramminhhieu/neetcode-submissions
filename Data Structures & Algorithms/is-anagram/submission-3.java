class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int counts[] = new int[26];
        for(char c : s.toCharArray()){
            counts[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            counts[c - 'a']--;
        }
        for(int i = 0; i < counts.length; i++){
            if(counts[i] != 0){
                return false;
            }
        }
        return true;
    }
}
