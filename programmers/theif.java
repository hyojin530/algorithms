//https://programmers.co.kr/learn/courses/30/lessons/42897

class Solution {
    public int solution(int[] money) {
        int num = money.length;
        int[][] dp = new int[num + 1][2];
        dp[1][0] = 0;
        dp[1][1] = money[0];
        for (int i = 2; i < num; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i - 1];
        }

        int ans1 = Math.max(dp[num - 1][0], dp[num - 1][1]);

        dp[2][0] = 0;
        dp[2][1] = money[1];
        for (int i = 3; i <= num; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i - 1];
        }

        int ans2 = Math.max(dp[num][0], dp[num][1]);
        int answer = Math.max(ans1, ans2);
        return answer;
    }
}