//https://programmers.co.kr/learn/courses/30/lessons/42898

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];
        int[][] access = new int[m + 1][n + 1];

        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = 0;
            access[puddle[0]][puddle[1]] = -1;
        }
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (access[i][j] != -1) {
                    if (i == 1 && j == 1)
                        continue;
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }

        int answer = dp[m][n];
        return answer;
    }
}