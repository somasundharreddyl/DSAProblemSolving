class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pSize=p.length();
        int sSize=s.length();
        List<Integer> ans=new ArrayList<>();
        if(pSize>sSize){
            return ans;
        }
        Map<Character,Integer> pMap=new HashMap<>();
        Map<Character,Integer> sMap=new HashMap<>();
        for(int i=0;i<p.length();i++){
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
        }
            for(int j=0;j<pSize;j++){
                sMap.put(s.charAt(j),sMap.getOrDefault(s.charAt(j),0)+1);
            }
            int matchCount=0;
            for(char key:pMap.keySet()){
               if(sMap.containsKey(key)){
                  if(sMap.get(key)<=pMap.get(key)){
                      matchCount+=sMap.get(key); 
                  }else{
                    matchCount+=pMap.get(key);
                  }   
               }
            }
            if(pSize==matchCount){
               ans.add(0);
            }    
        
         for(int i=1;i<=s.length()-pSize;i++){
            if(pMap.containsKey(s.charAt(i-1)) && sMap.get(s.charAt(i-1))<=pMap.get(s.charAt(i-1))){
                matchCount--;
            }
            sMap.put(s.charAt(i-1),sMap.get(s.charAt(i-1))-1);
            sMap.put(s.charAt(i+pSize-1),sMap.getOrDefault(s.charAt(i+pSize-1),0)+1);
            if(pMap.containsKey(s.charAt(i+pSize-1)) && sMap.get(s.charAt(i+pSize-1))<=(pMap.get(s.charAt(i+pSize-1)))){
                matchCount++;
            }  
            
           if(pSize==matchCount){
               ans.add(i);
            }
        }
        return ans;
    }
}