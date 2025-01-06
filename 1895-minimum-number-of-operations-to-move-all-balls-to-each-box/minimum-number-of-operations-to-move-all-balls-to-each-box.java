class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        char ch[]=boxes.toCharArray();
        int currSum=0;
        int back=0;
        int front=0;
        for(int i=0;i<n;i++){
            if(ch[i]=='1'){
                currSum+=i;
                front++;
            }
        }
        int ans[]=new int[n];
        // ans[0]=currSum;
        // //  if(ch[0]=='1'){
        // //         front--;
        // //         back++;
        // //     }
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(currSum);
            if(ch[i]=='1'){
                front--;
                back++;
            }
            System.out.print(front+" "+back+" ");
            currSum=currSum-front+back;
            
        }
        return ans;
    }
}