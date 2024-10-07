import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int prev = 0, h = health;
        for (int[] attack: attacks) {
            h += ((attack[0] - prev - 1) * bandage[1]) + (((attack[0] - prev - 1) / bandage[0]) * bandage[2]);
            prev = attack[0];
            if (h > health) h = health;
            h -= attack[1];
            if (h <= 0) return -1;
        }
        return h;
    }
}