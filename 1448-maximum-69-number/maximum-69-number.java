class Solution {
    public int maximum69Number (int num) {

        String nums=Integer.toString(num);
        int n=nums.length();
        char ch[]=nums.toCharArray();
        StringBuilder sb=new StringBuilder();
        int idx=0;
        while(idx<n){
            if(ch[idx]=='6'){
                sb.append("9");
                if(idx+1<n){
                    sb.append(nums.substring(idx+1,n));
                }
                break;
            }else{
                sb.append(ch[idx]);
            }
            idx++;
        }
        return Integer.parseInt(sb.toString());
    }
}