class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n=chalk.length;
        long sum=0;
        for(int i:chalk) sum+=(long)i;
        long rem=(long)k%sum;
        int idx=0;
        while(rem>=chalk[idx%n]){
            rem-=(long)chalk[idx];
            idx++;
        }
        return idx%n;
    }
}