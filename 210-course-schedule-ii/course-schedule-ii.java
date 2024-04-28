class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int in[]=new int[numCourses];
         ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
         for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
         }
         for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            graph.get(v).add(u);
            in[u]++;
         }

         Queue<Integer> q=new LinkedList<>();
         boolean check[]=new boolean[numCourses];
         for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.add(i);
               // check[i]=true;
            }
         }
         int ans[]=new int[numCourses];
         int idx=0;
         while(q.size()>0){
            int curr=q.poll();
           // in[curr]--;
            check[curr]=true;
            ans[idx++]=curr;
            if(graph.get(curr).size()>0){
            for(int i=0;i<graph.get(curr).size();i++){
                in[graph.get(curr).get(i)]--;
                if(in[graph.get(curr).get(i)]==0)
                q.add(graph.get(curr).get(i));
                // check[graph.get(curr).get(i)]=true;
                // //in[graph.get(curr).get(i)]--;
                // graph.get(curr).remove(i);
               
            }
            }
         }

         for(int i=0;i<numCourses;i++){
            if( check[i]==false) return new int[]{};
         }
         return ans;
    }
}