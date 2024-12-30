class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Pair> p=new PriorityQueue<>((a,b)->Double.compare(a.div,b.div));
        for(int i=0;i<n-1;i++){
            p.add(new Pair((double)arr[i]/(double)arr[n-1],i,n-1));
        }
       // k--;
        int p1=0;
        int p2=n-2;
        int smallest=1;
        while(smallest<k){
            Pair curr=p.poll();
            int i=curr.a;
            int j=curr.b-1;
            p.add(new Pair(1.0*arr[i]/arr[j],i,j));
            smallest++;
        }
        int ans[]=new int[2];
        ans[0]=arr[p.peek().a];
        ans[1]=arr[p.peek().b];
        return ans;
    }
}
class Pair{
    double div;
    int a;
    int b;
    Pair(double div, int a, int b){
        this.div=div;
        this.a=a;
        this.b=b;
    }
}