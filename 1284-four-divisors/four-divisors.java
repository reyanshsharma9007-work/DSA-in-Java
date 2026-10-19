class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        if(nums.length==0)return 0;
        for(int i=0;i<nums.length;i++){
            sum+=eachSum(nums[i]);
        }
        return sum;
    }
    private int eachSum(int n) {
        int s = 0;
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                s += i;

                if (i != n / i) {
                    count++;
                    s += n / i;
                }

                if (count > 4) {
                    return 0;
                }
            }
        }

        return count == 4 ? s : 0;
    }
}