class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=wage.length;
        double min=Double.MAX_VALUE;
        Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pair(1.0*wage[i]/quality[i], quality[i]);
        }
        Arrays.sort(arr,(a,b)->Double.compare(a.ratio,b.ratio));
        double sum=0;
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k-1;i++){
            p.add(arr[i].qual);
            sum+=arr[i].qual;
        }
        
        for(int i=k-1;i<n;i++){
            sum+=arr[i].qual;
            p.add(arr[i].qual);
            if(p.size()>k){
                sum-=p.poll();
            }
            min=Math.min(min,sum*arr[i].ratio);
        }
        return min;
    }
}
class Pair{
    double ratio;
    int qual;
    Pair(double ratio, int qual){
        this.ratio=ratio;
        this.qual=qual;
    }
}