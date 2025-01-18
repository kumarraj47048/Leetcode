class Solution {
    public double angleClock(int hour, int minutes) {
        double hh=(1.0*minutes/60)*30+hour*30;
        double mm=6*minutes;
        double x=Math.abs(hh-mm);
        if(x>180) return 360-x;
        else return x;
    }
}