class ATM {
    int arr[];
    int den[]=new int[]{20,50,100,200,500};
    public ATM() {
        arr=new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++){
           arr[i]+=banknotesCount[i];
        }
        
    }
    
    public int[] withdraw(int amount) {
        int curr=amount;
        int ans[]=new int[5];
        int temp[]=new int[5];
        for(int i=0;i<5;i++) temp[i]=arr[i];
        for(int i=4;i>=0;i--){
                // while(amount>=den[i] && temp[i]>0){
                //     amount-=den[i];
                //     temp[i]--;
                //     ans[i]++;
                // }
                int times=Math.min(amount/den[i], temp[i]);
                amount-=times*den[i];
                temp[i]-=times;
                ans[i]+=times;
        }
        
        if(amount>0) return new int[]{-1};
        else{
           for(int i=0;i<5;i++) arr[i]=temp[i];
            return ans;
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */