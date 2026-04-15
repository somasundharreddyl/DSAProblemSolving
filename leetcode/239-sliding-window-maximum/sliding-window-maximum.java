class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        dq.add(nums[0]);
        for(int i=1;i<k;i++){
            if(dq.size()==0){
              dq.addFirst(nums[i]);
            }else if(nums[i]>dq.getFirst()){
          while(dq.size()>0 && nums[i]>dq.getFirst()){
            dq.removeFirst();
          }
          dq.addFirst(nums[i]);
        }else{
           while(dq.size()>0 && nums[i]>dq.getLast()){
              dq.removeLast();
           }
           dq.addLast(nums[i]);
        }
        }
        int[] ans=new int[n-k+1];
        ans[0]=dq.getFirst();
        for(int i=k;i<n;i++){
        if(dq.getFirst()==nums[i-k]){
           dq.removeFirst();
        }
        if(dq.size()==0){
              dq.addFirst(nums[i]);
        }       
        else if(nums[i]>dq.getFirst()){
          while(dq.size()>0 && nums[i]>dq.getFirst()){
            dq.removeFirst();
          }
          dq.addFirst(nums[i]);
        }else{
           while(dq.size()>0 && nums[i]>dq.getLast()){
              dq.removeLast();
           }
           dq.addLast(nums[i]);
        }
        ans[i-k+1]=dq.getFirst(); 
        }
        return ans;
    }
}