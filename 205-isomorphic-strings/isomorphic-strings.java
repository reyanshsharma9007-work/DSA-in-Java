class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Character> charMapping=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char orignal=s.charAt(i);
            char replacement=t.charAt(i);

            if(!charMapping.containsKey(orignal)){
                if(!charMapping.containsValue(replacement)){
                charMapping.put(orignal,replacement);
                }
                else return false;
            }
            else {
                char mappedChar=charMapping.get(orignal);
                if(mappedChar!=replacement){
                    return false;
                }
            }
        }
        return true;
    }
}