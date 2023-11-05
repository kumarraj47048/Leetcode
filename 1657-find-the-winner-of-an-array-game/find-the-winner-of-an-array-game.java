class Solution {
    public int getWinner(int[] arr, int k) {
      int maxE=arr[0];
      int n=arr.length;
      
        int cL=0;
      for(int i=1;i<n;i++){
         if(maxE>arr[i]){
             cL++;
             if(cL==k) return maxE;
         }
          else{
              cL=1;
              maxE=arr[i];
              if(cL==k) return maxE;
          }
      }
        return maxE;
    }
}