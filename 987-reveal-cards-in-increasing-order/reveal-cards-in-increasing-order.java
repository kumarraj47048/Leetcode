class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        Deque<Integer> d=new LinkedList<>();
        Arrays.sort(deck);
        d.offerFirst(deck[n-1]);
        for(int i=n-2;i>=0;i--){
            d.offerFirst(d.pollLast());
            d.offerFirst(deck[i]);
        }
        int ans[]=new int[n];
        int idx=0;
        while(!d.isEmpty()){
            ans[idx++]=d.pollFirst();
        }
        return ans;
    }
}