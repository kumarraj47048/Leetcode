class Solution {
    public int maxFrequencyElements(int[] nums) {
        int ct[]=new int[101];
        for(int i: nums) ct[i]++;
        int max=-1;
        int c=0;
        
        for(int i:ct) max=Math.max(max,i);
        for(int i=0;i<=100;i++){
            if(ct[i]==max) c+=ct[i];
        }
            
        return c;    
        
    }
}