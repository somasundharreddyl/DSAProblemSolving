class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[l-k+1];
        dq.add(nums[0]);
        int idx=0;
        for(int i=1;i<k;i++){
            while(dq.size()>0 && nums[i]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        ans[idx++]=dq.peekFirst();
        for(int i=k;i<l;i++){
            if(dq.peekFirst()==nums[i-k]){
                dq.removeFirst();
            }
            while(dq.size()>0 && nums[i]>dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            ans[idx++]=dq.peekFirst();
        }
        return ans;
    }
}