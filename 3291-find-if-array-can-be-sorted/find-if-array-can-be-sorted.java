class Solution {
    public boolean canSortArray(int[] nums) {
        int n=nums.length;
        int ct[]=new int[n];
        for(int i=0;i<n;i++){
            ct[i]=Integer.bitCount(nums[i]);
        }
        
        for(int i=0;i<n;i++) System.out.print(ct[i]+" ");
        System.out.println();
        ArrayList<Integer> maxL=new ArrayList<>();
         ArrayList<Integer> minL=new ArrayList<>();
       
        for(int i=0;i<n;i++){
            int max=nums[i];
            int min=nums[i];
            while(i<n-1 && ct[i]==ct[i+1]){
                max=Math.max(max,nums[i+1]);
                min=Math.min(min,nums[i+1]);
                i++;
            }
            //if(i<n-1 && max>nums[i+1]) return false;
            
            maxL.add(max);
            minL.add(min);
        }
        
        // for(int i=0;i<maxL.size();i++){
        //     System.out.print(maxL.get(i)+" ");
        // }
        // System.out.println();
        //  for(int i=0;i<minL.size();i++){
        //     System.out.print(minL.get(i)+" ");
        // }
        // System.out.println();
        
        for(int i=0;i<maxL.size()-1;i++){
            if(maxL.get(i)>minL.get(i+1)) return false;
        }
        return true;
    }
}