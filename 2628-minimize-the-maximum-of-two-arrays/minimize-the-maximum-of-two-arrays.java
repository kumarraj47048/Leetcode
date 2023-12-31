class Solution {
    public int minimizeSet(int divisor1, int divisor2, int u1, int u2) {
        long l=u1+u2, r=2*(1000000000);
        long ans=r;
        long lcm=((long)divisor1*(long)divisor2)/gcd((long)divisor1,(long)divisor2);
        while(l<=r){
            long m=l+(r-l)/2;
            long a=m-(m/divisor1);  // no. of elements which are not divisble by divisor1
            long b=m-(m/divisor2);  // no. of elements which are not divisible by divisor2
            
            long c= m-m/lcm;
            if(a>=u1 && b>=u2 && (c)>=u1+u2){
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return (int)ans;
    }

    public static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}