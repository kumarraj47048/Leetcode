class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
       // HashMap<Integer,Integer> hm2=new HashMap<>();
        int n=A.length;
        int ct=0;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            hm.put(A[i],hm.getOrDefault(A[i],0)+1);
            if(hm.get(A[i])==2) ct++;
            hm.put(B[i],hm.getOrDefault(B[i],0)+1);
            if(hm.get(B[i])==2) ct++;
            
            ans[i]=ct;
        }
        return ans;
    }
}