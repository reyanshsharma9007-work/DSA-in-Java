class Solution {
    public boolean isAnagram(String s, String t) {
        s=s.toLowerCase();
        t=t.toLowerCase();
        s=s.replace(" ","");
        t=t.replace(" ","");
        int[] bucket=new int[26];
        for(int i=0;i<s.length();i++){
            bucket[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            bucket[t.charAt(i)-'a']--;
        }

        for(int count:bucket){
            if(count!=0)return false;
        }
        return true;
    }
}