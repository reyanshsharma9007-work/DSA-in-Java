class Solution {
    public int findPeakElement(int[] nums) {
        int ind=0;
        if(nums.length==1)return ind;
        if(nums[0]>nums[1])return ind;
        if(nums[nums.length-1]>nums[nums.length-2])return nums.length-1;
        int low=1;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])return mid;
            else if(nums[mid]>nums[mid-1])low=mid+1;
            else if(nums[mid]>nums[mid+1])high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}