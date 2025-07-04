class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> hms=new HashMap<>();
        Map<Character,Integer> hmp=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        if(p.length()>s.length()){return ans;}
        int size=p.length();
        for(int i=0;i<p.length();i++){
            hmp.put(p.charAt(i),hmp.getOrDefault(p.charAt(i),0)+1);   
        }
        int count=0;
        int start=0,end=size-1;
        for(int i=start;i<=end;i++){
            hms.put(s.charAt(i),hms.getOrDefault(s.charAt(i),0)+1);
            if(hms.get(s.charAt(i))<=hmp.getOrDefault(s.charAt(i),0)){
                     count++;
            }
        }
        if(size==count){
            ans.add(start);
        }
        start++;
        end++;
        while(end<s.length()){
            hms.put(s.charAt(start-1),hms.get(s.charAt(start-1))-1);
            if(hms.get(s.charAt(start-1))<hmp.getOrDefault(s.charAt(start-1),0)){
                     count--;
            }
            hms.put(s.charAt(end),hms.getOrDefault(s.charAt(end),0)+1);
            if(hms.get(s.charAt(end))<=hmp.getOrDefault(s.charAt(end),0)){
                     count++;
            }
             if(size==count){
            ans.add(start);
        }
        start++;
        end++;
        }
        return ans;
    }
}