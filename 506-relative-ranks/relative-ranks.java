import java.util.*;
class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n=score.length;
        Integer arr[]=new Integer[n];
       for(int i=0;i<n;i++) arr[i]=score[i];
       String ans[]=new String[n];
       Arrays.sort(arr, Collections.reverseOrder());
       
       HashMap<Integer,String> map=new HashMap<>();
       for(int i=0;i<n;i++){
         System.out.print(arr[i]+" ");
        if(i==0) map.put(arr[i],"Gold Medal");
        else if(i==1) map.put(arr[i],"Silver Medal");
        else if(i==2) map.put(arr[i],"Bronze Medal");
        else map.put(arr[i],Integer.toString(i+1));
       } 

       for(int i=0;i<n;i++){
        ans[i]=map.get(score[i]);
       }
       return ans;
    }
}