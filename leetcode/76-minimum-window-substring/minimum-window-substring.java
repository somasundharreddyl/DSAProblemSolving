class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        if(s.length()<t.length()){
            return ans;
        }
        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> tMap=new HashMap<>();
        for(char ch:t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        int start=0,end=0,ansStartIdx=0,ansEndIdx=0,matchCount=0,anslen=Integer.MAX_VALUE;
        
            while(end<s.length()){
            if(matchCount==t.length()){
                if(ansStartIdx==0 && ansEndIdx==0){
                   ansStartIdx=start;
                   ansEndIdx=end;
                }else if(ansEndIdx-ansStartIdx>end-start){
                   ansStartIdx=start;
                   ansEndIdx=end;
                }
              sMap.put(s.charAt(start),sMap.get(s.charAt(start))-1);  
              if(sMap.get(s.charAt(start))<tMap.getOrDefault(s.charAt(start),0)){
                    matchCount--;                                            
              }
              
              start++;
            }
            else{
                sMap.put(s.charAt(end),sMap.getOrDefault(s.charAt(end),0)+1);
                if(sMap.get(s.charAt(end))<=tMap.getOrDefault(s.charAt(end),0)){
                    matchCount++;
                }
                end++;
            }
        }
        while(matchCount==t.length()){
           if(ansStartIdx==0 && ansEndIdx==0){
                   ansStartIdx=start;
                   ansEndIdx=end;
                }else if(ansEndIdx-ansStartIdx>end-start){
                   ansStartIdx=start;
                   ansEndIdx=end;
                }
                sMap.put(s.charAt(start),sMap.get(s.charAt(start))-1);
              if(sMap.get(s.charAt(start))<tMap.getOrDefault(s.charAt(start),0)){
                    matchCount--;                                            
              }
              
              start++; 
        }
        return s.substring(ansStartIdx,ansEndIdx);
    }
}