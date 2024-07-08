class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ct=0;
        int empty=numBottles;
        while(empty>=numExchange ){
             ct+=numExchange;
             empty-=numExchange;
             empty++;
        }
        return ct+empty;
    }
}