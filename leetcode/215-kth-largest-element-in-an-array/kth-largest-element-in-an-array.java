class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minPq=new PriorityQueue<>(); 
       for(int i=0;i<k;i++){
        minPq.add(nums[i]);
       }
       for(int i=k;i<nums.length;i++){
        if(nums[i]>minPq.peek()){
            minPq.remove();
            minPq.add(nums[i]);
        }
       }
       return minPq.peek();
    }
}