class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        PriorityQueue<Pair> p=new PriorityQueue<>((a,b)->b.sum-a.sum);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               // p.add(new Pair(nums1[i],nums2[j], nums1[i]+nums2[j]));
                if(p.size()<k) p.add(new Pair(nums1[i],nums2[j],nums1[i]+nums2[j]));
                else if(p.peek().sum > nums1[i]+nums2[j]){
                    p.poll();
                    p.add(new Pair(nums1[i],nums2[j],nums1[i]+nums2[j]));
                }
                else break;
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        while(p.size()>0){
            List<Integer> in=new ArrayList<>();
            in.add(p.peek().a);
            in.add(p.peek().b);
            ans.add(in);
            p.poll();
        }
        return ans;
    }
}
class Pair{
    int a;
    int b;
    int sum;
    Pair(int a,int b,int sum){
       this.a=a;
       this.b=b;
       this.sum=sum;
    }
}