class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int big=(1<<20)-1;
    public int minimumValueSum(int[] nums, int[] andValues) {
       int ans=solve(0,big,0,andValues,nums);
       if(ans==1073741823) return -1;
       return ans;
    }
    public int solve(int idx, int andV, int k, int andValues[],int nums[]){
        int n=nums.length;
        int m=andValues.length;
         
        if(k>=m){
            if(idx==n) return 0;
            else return Integer.MAX_VALUE/2;
        }
        
        if(idx>=n) return Integer.MAX_VALUE/2;
        
        String key=idx+","+andV+","+k;
        if(map.containsKey(key)) return map.get(key);

        int take=nums[idx]&(andV);
        int a=Integer.MAX_VALUE/2;
        int b=Integer.MAX_VALUE/2;
        if(take==andValues[k]){
            a=nums[idx]+solve(idx+1,big,k+1,andValues,nums);
            b=solve(idx+1,take,k,andValues,nums);
        }
        else{
            //a=solve(idx+1,big,k+1,andValues,nums);
            b=solve(idx+1,take,k,andValues,nums);
        }
     

     map.put(key,Math.min(a,b));
      
    return Math.min(a,b);
    }
}