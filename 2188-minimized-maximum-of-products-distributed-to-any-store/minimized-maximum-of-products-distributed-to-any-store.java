class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low=Integer.MAX_VALUE;
        int high=1;
       
        for(int i:quantities){
            low=Math.min(low,i);
            high=Math.max(high,i);
        }
        int ans=high;
        low=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(check(n,quantities,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public static boolean check(int n, int quantities[], int x){
        int temp=n;
       System.out.println(x);
        int len=quantities.length;
        int idx=0;
        while(idx<len && temp>0){
            int ct=quantities[idx]/x;
            if(quantities[idx]%x>0) ct++;
            if(ct>temp) return false;
            temp-=ct;
            idx++;
        }
        if(idx<len) return false;
        return true;
    }
}