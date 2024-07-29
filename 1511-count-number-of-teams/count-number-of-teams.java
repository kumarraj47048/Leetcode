class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
        int ct=0;
        for(int i=1;i<n-1;i++){
            int leftL=0;
            int leftG=0;
            for(int j=i-1;j>=0;j--){
                if(rating[j]<rating[i]) leftL++;
                if(rating[j]>rating[i]) leftG++;
            }

            int rightL=0;
            int rightG=0;

            for(int j=i+1;j<n;j++){
                if(rating[j]>rating[i]) rightG++;
                if(rating[j]<rating[i]) rightL++;
            }

            ct+=(leftL*rightG);
            ct+=(leftG*rightL);
        }
        return ct;
    }
}