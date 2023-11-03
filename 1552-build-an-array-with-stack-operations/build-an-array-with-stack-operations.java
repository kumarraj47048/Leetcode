class Solution {
    public List<String> buildArray(int[] target, int n) {
        int sz=target.length;
        Arrays.sort(target);
        boolean ch[]=new boolean[target[sz-1]+1];
        for(int i=0;i<target.length;i++){
            ch[target[i]]=true;
        }

        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<=target[sz-1];i++){
            list.add("Push");
            if(ch[i]==false) list.add("Pop");
        }
        return list;
    }
}