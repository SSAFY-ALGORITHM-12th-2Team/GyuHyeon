class Solution {
    class Num {
        int num;
        int setbit;
        Num (int num, int setbit) {
            this.num = num;
            this.setbit = setbit;
        }
    }
    void swap(Num n1, Num n2) {
        Num tmp = n1; 
        n1 = n2;
        n2 = tmp;
    }
    public boolean canSortArray(int[] nums) {
        Num[] bnums = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            String str = Integer.toBinaryString(nums[i]);
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) if (str.charAt(j) == '1') cnt++;
            bnums[i] = new Num(nums[i], cnt);
        }

        for (int i = 0; i < bnums.length - 1; i++) {
            for (int j = i + 1; j < bnums.length; j++) {
                if (bnums[i].num > bnums[j].num) {
                    if (bnums[i].setbit == bnums[j].setbit) swap(bnums[i], bnums[j]);
                    else return false;
                }
            }
        }
        return true;
    }
}