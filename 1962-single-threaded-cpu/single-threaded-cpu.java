class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Pair> rightPq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        PriorityQueue<Pair> leftPq=new PriorityQueue<>((a,b)->{
            if (a.val != b.val) {
                return a.val - b.val; // Compare by processing time
            }
            return a.idx - b.idx;     // Tie-break by index
        });
        int time=1;
        int idx=0;
        int n=tasks.length;
        int ans[]=new int[n];
        int tempIdx=0;
        int arr[][]=new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        time=arr[0][0];
        int resultIdx=0;
        while(resultIdx<n){
            while(idx<n && arr[idx][0]<=time){
                leftPq.add(new Pair(arr[idx][0],arr[idx][1],arr[idx][2]));
                idx++;
            }
            if(leftPq.size()>0){
                ans[resultIdx++]=leftPq.peek().idx;
                time+=leftPq.poll().val;
            }
            else time=arr[idx][0];
        }

    return ans;
    }
}
class Pair{
    int time,val,idx;
    Pair(int time, int val, int idx){
        this.time=time;
        this.val=val;
        this.idx=idx;
    }
}