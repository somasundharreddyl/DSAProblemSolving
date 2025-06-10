class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minpq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minpq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(minpq.peek()<nums[i]){
              minpq.remove();
              minpq.add(nums[i]);
            }
        }
        return minpq.peek();
    }
}