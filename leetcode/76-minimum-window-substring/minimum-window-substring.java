class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        if(s.length()<t.length()){
            return ans;
        }
        Map<Character,Integer> hms=new HashMap<>();
        Map<Character,Integer> hmt=new HashMap<>();
        for(int i=0;i<t.length();i++){
            hmt.put(t.charAt(i),hmt.getOrDefault(t.charAt(i),0)+1);
        }
        int size=t.length(),count=0;
        int start=0,end=0;
        while(end<s.length()){
            char ch=s.charAt(end);
             hms.put(ch,hms.getOrDefault(ch,0)+1);
             if(hms.get(ch)<=hmt.getOrDefault(ch,0)){
                count++;
             }
             while(count==size){
                if(ans.equals("")){
                    ans=s.substring(start,end+1);
                }else{
                    ans=ans.length()<end-start+1?ans:s.substring(start,end+1);
                }
                hms.put(s.charAt(start),hms.get(s.charAt(start))-1);
                if(hms.get(s.charAt(start))<hmt.getOrDefault(s.charAt(start),0)){
                count--;
                }
                start++;
             }
             end++;
        }
        while(count==size){
                if(ans.equals("")){
                    ans=s.substring(start,end+1);
                }else{
                    ans=ans.length()<end-start+1?ans:s.substring(start,end+1);
                }
                hms.put(s.charAt(start),hms.get(s.charAt(start))-1);
                if(hms.get(s.charAt(start))<hmt.getOrDefault(s.charAt(start),0)){
                count--;
                }else{
                start++;
                }
             }
        return ans;
    }
}