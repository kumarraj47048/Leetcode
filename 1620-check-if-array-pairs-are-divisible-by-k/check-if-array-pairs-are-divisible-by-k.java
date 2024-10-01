class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ct[]=new int[100001];
        int max=0;
        for(int i:arr){
            ct[Math.abs(i%k+k)%k]++;
            max=Math.max(max,i%k);
        }
        //for(int i:ct) System.out.print(i+" ");
        for(int i=0;i<k;i++){
            if(i==0 && ct[i]%2==1) return false;
            if(ct[Math.abs((k-i%k))%k]!=ct[i]) return false;
        }

    return true;
    }
}