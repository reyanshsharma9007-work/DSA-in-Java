class Solution {
    public String largestOddNumber(String num) {
        //Length of the string
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            if((num.charAt(i)-'0')%2!=0)return new StringBuilder(num).substring(0,i+1).toString();
        }
        return "";
    }

}