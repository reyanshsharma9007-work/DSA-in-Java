class Solution {
    private static int countbits(int n){
        int count=0;
        while(n>1){
            if(n%2==1)count+=1;
            n=n/2;
        }
        if(n==1)count+=1;
        return count;
    }
    public int minBitFlips(int start, int goal) {
        int ans=start^goal;
        return countbits(ans);
    }
}