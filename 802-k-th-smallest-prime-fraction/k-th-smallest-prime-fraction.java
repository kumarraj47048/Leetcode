class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Pair> p=new PriorityQueue<Pair>((a,b)->Double.compare(b.div,a.div));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                p.add(new Pair((double)arr[i]/(double)arr[j],arr[i],arr[j]));
                if(p.size()>k) p.poll();
            }
        }
        int ans[]=new int[2];
        ans[0]=p.peek().a;
        ans[1]=p.peek().b;
        return ans;
    }
}
class Pair{
    double div;
    int a;
    int b;
    Pair(double div,int a, int b){
        this.div=div;
        this.a=a;
        this.b=b;
    }
}