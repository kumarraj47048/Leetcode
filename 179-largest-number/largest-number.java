class Solution {
    public String largestNumber(int[] nums) {
       int n=nums.length;
       String s[]=new String[n];
       
       for(int i=0;i<n;i++)
         s[i]=String.valueOf(nums[i]);

         Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
         StringBuilder sb=new StringBuilder("");
         for(int i=0;i<n;i++){
               sb.append(s[i]);
         }

         String result=sb.toString();
    if(result.startsWith("0"))
    return "0";
    return result;
    }
}