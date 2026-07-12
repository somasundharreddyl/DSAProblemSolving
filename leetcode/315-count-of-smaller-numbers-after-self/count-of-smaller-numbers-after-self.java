class Solution {
    public List<Integer> countSmaller(int[] nums) {
       List<Integer> counts=new ArrayList<>(Collections.nCopies(nums.length, 0));
       Pair[] pairs=new Pair[nums.length]; 
       for(int i=0;i<nums.length;i++){
         pairs[i]=new Pair(nums[i],i);
       }
       splitArr(pairs,0,nums.length-1,counts);
       return counts; 
    }
    public void splitArr(Pair[] pairs,int s, int e, List<Integer> counts){
       if(s>=e){
        return;
       }
       int m=s+(e-s)/2;
       splitArr(pairs,s,m,counts);
       splitArr(pairs,m+1,e,counts);
       mergeArr(pairs,s,m,e,counts);
    }
    public void mergeArr(Pair[] pairs,int s, int m, int e, List<Integer> counts){
         Pair[] temp=new Pair[e-s+1];
         int s1=s,s2=m+1,i=0;
         while(s1<=m && s2<=e){
            if(pairs[s1].value>pairs[s2].value){
               int idx=pairs[s1].idx;
               counts.set(idx,counts.get(idx)+e-s2+1);
               temp[i++]=pairs[s1++];
            }else{
               temp[i++]=pairs[s2++];
            }
         }
         while(s1<=m){
        //    int idx=pairs[s1].idx;
        //    counts.set(idx,counts.get(idx)+m-s1+1);
           temp[i++]=pairs[s1++];
         }
         while(s2<=e){
        //    int idx=pairs[s2].idx;
        //    counts.set(idx,counts.get(idx)+e-s1+1);
           temp[i++]=pairs[s2++];
         }
         int k=0;
         for(int j=s;j<=e;j++){
            pairs[j]=temp[k++];
         }
    }

}
class Pair{
    int value;
    int idx;
    public Pair(int value, int idx){
        this.value=value;
        this.idx=idx;
    }
}