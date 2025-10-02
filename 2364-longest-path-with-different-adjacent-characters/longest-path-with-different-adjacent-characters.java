class Solution {
    public int max=1;
    public int longestPath(int[] parent, String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        ArrayList<Integer> tree[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }

        for(int i=1;i<n;i++){
            int u=i;
            int v=parent[i];

            tree[u].add(v);
            tree[v].add(u);
        }

        int x=dfs(0,-1,tree,ch);
        return max;

    }

    public int dfs(int root, int par, ArrayList<Integer> tree[], char ch[]){
        
        ArrayList<Integer> val=new ArrayList<>();
        // val.add(0);
        // val.add(0);
        char curr=ch[root];
        for(int v: tree[root]){
            if(v!=par && curr!=ch[v]){
                int down=1+dfs(v,root,tree,ch);
                val.add(down);
            }
            else if(v!=par) dfs(v,root,tree,ch);
        }

        Collections.sort(val);
        int sz=val.size();
        
        if(sz>=2){
            max=Math.max(max,val.get(sz-1)+val.get(sz-2)-1);
        }
        if(sz==1) max=Math.max(max,val.get(0));
        if(val.size()==0) return 1;
        return val.get(sz-1); 
    }
}