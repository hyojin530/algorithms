//https://programmers.co.kr/learn/courses/30/lessons/43105

class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int leaf = triangle[depth - 1].length;

        int[][] dp = new int[depth + 1][leaf];
        dp[1][0] = triangle[0][0];

        for (int i = 2; i <= depth; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i - 1][j];
                } else if (j == i - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < depth; i++) {
            answer = Math.max(answer, dp[depth][i]);
        }

        return answer;
    }
}