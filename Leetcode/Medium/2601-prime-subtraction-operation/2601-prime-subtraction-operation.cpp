class Solution {
public:
    vector<int> prime;
    bool primeSubOperation(vector<int>& nums) {
        int n = nums.size();
        prime = vector<int>(1001, -1);
        for (int i = 0; i < n; i++) {
            for (int j = nums[i] - 1; j >= 2; j--) {
                if (isPrime(j) && (i == 0 || (i > 0 && nums[i] - j > nums[i-1]))) {
                    cout << "prime j:" << j << endl;
                    nums[i] -= j;
                    break;
                }
            }
            if (i != 0 && nums[i-1] >= nums[i]) return false;
            cout << nums[i] << endl;
        }
        return true;
    }
    int isPrime(int num) {
        if (prime[num] == -1) {
            int val = 1;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    val = 0;
                    break;
                }
            }
            return prime[num] = val;
        }
        return prime[num];
    }
};