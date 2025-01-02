class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pair(profits[i],capital[i]);
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a.c,b.c));
        PriorityQueue<Pair> p=new PriorityQueue<>((a,b)->Integer.compare(b.p,a.p));
        
        int idx=0;
        while(k-->0){
            while(idx<n && w>=arr[idx].c){
                p.add(new Pair(arr[idx].p, arr[idx].c));
                idx++;
            }
            if(p.size()>0)
            w+=p.poll().p;
        }
        return w;
    }
}
class Pair{
    int p;
    int c;
    Pair(int p, int c){
        this.p=p;
        this.c=c;
    }
}