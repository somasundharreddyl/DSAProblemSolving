class Pair{ 
    int ele; 
    int idx; 
    Pair(int ele , int idx){ 
        this.ele = ele; 
        this.idx = idx; 
    }     
}
class Solution { 
    public List<Integer> countSmaller(int[] nums) { 
        int n = nums.length; 
        int[] count = new int[n]; 
        Pair[] arr = new Pair[n]; 
        for(int i = 0; i<n; i++){ 
            arr[i] = new Pair(nums[i],i); 
        } 
        mergeSort(arr,count,0,n-1); 
        List<Integer> ans = new ArrayList<>(); 
        for(int ele : count) ans.add(ele); 
        return ans; 
    }
     public void mergeSort(Pair[] arr,int[] count,int l,int r){ 
        if(l>=r) return; 
        int m = (l+r)/2; 
        mergeSort(arr,count,l,m); 
        mergeSort(arr,count,m+1,r); 
        mergeTwoSorted(arr,count,l,m,r); 
    } 
    public void mergeTwoSorted(Pair[] nums,int[] count,int l,int m,int r){ 
        int s1 = m-l+1; 
        int s2 = r-m; 
        Pair[] arr1 = new Pair[s1]; 
        Pair[] arr2 = new Pair[s2]; 
        for(int i = 0; i<s1; i++){ 
            arr1[i] = nums[i+l]; 
        } 
        for(int i = 0; i<s2; i++){ 
            arr2[i] = nums[i+m+1]; 
        } 
        int i = 0,j = 0,k = l; 
        while(i<s1 && j<s2){ 
            if(arr1[i].ele>arr2[j].ele){ 
                count[arr1[i].idx] += s2-j; 
                nums[k++] = arr1[i++]; 
            } else { 
                nums[k++] = arr2[j++]; 
            } 
        } 
        while(i<s1) nums[k++] = arr1[i++]; 
        while(j<s2) nums[k++] = arr2[j++];    
    } 
}  