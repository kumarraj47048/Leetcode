class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }

        Arrays.sort(arr,(a,b)->(b[1]-a[1]));
        
        PriorityQueue<Integer> p=new PriorityQueue<>();
        long sum=0;
        long result=0;
        long min=100001;
        for(int i=0;i<k;i++){
            sum+=arr[i][0];
            p.add(arr[i][0]);
        }
        //min=p.peek();
        result=Math.max(result,sum*(arr[k-1][1]));
        for(int i=k;i<n;i++){
            sum+= arr[i][0]- p.poll();
            p.add(arr[i][0]);
            result=Math.max(result,sum*(arr[i][1]));
        }
        return result;
    }
}