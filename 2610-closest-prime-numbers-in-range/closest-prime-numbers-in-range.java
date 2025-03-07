class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean p[]=new boolean[1000001];
        p[1]=true;
        p[2]=false;
        for(int i=2;i<=1000;i++){
            if(p[i]==true) continue;
            for(int j=i*2;j<=1000000;j+=i){
                p[j]=true;
            }
        }
        int max=2000;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=1000000;i++){
            if(p[i]==false) list.add(i);
        }
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=left && list.get(i+1)<=right && list.get(i+1)-list.get(i)<max){
                ans[0]=list.get(i);
                ans[1]=list.get(i+1);
                max=list.get(i+1)-list.get(i);
            }
        }
        return ans;
    }
}