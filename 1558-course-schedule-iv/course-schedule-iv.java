class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans=new ArrayList<>();
        ArrayList<Integer> graph[]=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) graph[i]=new ArrayList<>();
        for(int i[]:prerequisites){
            int u=i[0];
            int v=i[1];
            graph[u].add(v);
           // graph[v].add(u);
        }
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            ans.add(check(graph,u,v));
        }
        return ans;
    }
    public static boolean check(ArrayList<Integer> graph[], int u, int v){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        q.add(u);
        set.add(u);
        while(q.size()>0){
            int curr=q.poll();
            for(int dest:graph[curr]){
                if(dest==v) return true;
                if(!set.contains(dest)){
                q.add(dest);
                set.add(dest);
                }
            }
        }
        return false;
    }
}