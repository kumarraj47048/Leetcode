class Solution {
    public long dividePlayers(int[] skill) {
        int n=skill.length;
        Arrays.sort(skill);
        long sum=0;
        int p1=0;
        int p2=n-1;
        int partSum=skill[0]+skill[n-1];
        while(p1<p2){
            if(skill[p1]+skill[p2]==partSum){
                sum+=(long)(skill[p1]*skill[p2]);
            }
            else return -1;
            p1++;
            p2--;
        }
        return sum;
    }
}