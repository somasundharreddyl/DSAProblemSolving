class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int s=0,e=nums1.length;
        int t=nums1.length+nums2.length;
        while(s<=e){
            int m1=s+(e-s)/2;
            int m2=((t)/2)-m1;
            int left1=(m1==0)?Integer.MIN_VALUE:nums1[m1-1];
            int left2=(m2==0)?Integer.MIN_VALUE:nums2[m2-1];
            int right1=(m1==nums1.length)?Integer.MAX_VALUE:nums1[m1];
            int right2=(m2==nums2.length)?Integer.MAX_VALUE:nums2[m2];
            if(left1<=right2 && right1>=left2){
                if(t%2==0){
                   return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }else{
                   return Math.min(right1,right2)*1.0;
                }
            }else if(right1<left2){
                s=m1+1;
            }else{
                 e=m1-1;
            }
        }
        return 0.0;
    }
}