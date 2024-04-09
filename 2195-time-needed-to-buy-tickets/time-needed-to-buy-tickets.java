class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ct=0;
        int idx=0;
        int n=tickets.length;
        while(tickets[k]>0){
            if(tickets[idx%n]>0)
            ct++;
            tickets[idx%n]--;
            idx++;
        }
        return ct;
    }
}