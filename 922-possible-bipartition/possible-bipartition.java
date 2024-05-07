class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
          
        ArrayList<Integer> graph[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        
        
        int color[]=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=0;i<dislikes.length;i++){
             int x=dislikes[i][0];
             int y=dislikes[i][1];
             graph[x].add(y);
             graph[y].add(x);
        }
        
        for(int i=1;i<=n;i++){
            int idx=i-1;
                if(color[i]==-1){
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            color[i]=0;
            while(q.size()>0){
                int curr=q.poll();
               
                for(int dest:graph[curr]){
                 
                    if(color[dest]==-1){
                        color[dest]=1-color[curr];
                        q.add(dest);
                    }
                    else if(color[dest]==color[curr]) return false;

                }
            }
              
            }
        }
        return true;
    }
}