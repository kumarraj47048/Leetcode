class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // we can just return nodes whose indegree is 0

        List<Integer> ans=new ArrayList<>();
        int lvl[]=new int[n];
        for(int i=0;i<edges.size();i++){
            int v=edges.get(i).get(1);
            lvl[v]++;
        }
        for(int i=0;i<n;i++){
            if(lvl[i]==0) ans.add(i);
        }
        return ans;
    }
}