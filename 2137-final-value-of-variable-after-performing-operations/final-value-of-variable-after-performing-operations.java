class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n=operations.length;
        int ct=0;
        for(String s:operations){
            if(s.equals("--X") || s.equals("X--")) ct--;
            else ct++;
        }
        return ct;
    }
}