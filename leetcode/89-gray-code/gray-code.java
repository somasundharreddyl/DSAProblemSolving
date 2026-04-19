class Solution {
    public List<Integer> grayCode(int n) {
       if(n==1){
        return List.of(0,1);
       } 
      List<Integer> temp = grayCode(n-1);
      List<Integer> ans=new ArrayList<>();
      for(int i=0;i<temp.size();i++){
            ans.add(temp.get(i));
      }
      for(int i=temp.size()-1;i>=0;i--){
        ans.add(temp.get(i)+(1<<(n-1)));
      }
      return ans;
    }
}