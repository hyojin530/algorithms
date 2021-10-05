//https://www.acmicpc.net/problem/1916
//최소비용

import java.util.Arrays;
import java.util.Scanner;

public class BJ1916 {
	static int N;
	static int M;
	static int START_CITY;
	static int END_CITY;
	static int[][] maps;
	static long[] cost;
	static boolean[] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maps = new int[N + 1][N + 1];

		for (int[] arr : maps) {
			Arrays.fill(arr, -1);
		}

		for (int i = 0; i < M; i++) {
			int from_city = sc.nextInt();
			int to_city = sc.nextInt();
			int cost = sc.nextInt();

			if (maps[from_city][to_city] == -1) {
				maps[from_city][to_city] = cost;
			} else if (maps[from_city][to_city] > cost) {
				maps[from_city][to_city] = cost;
			}
		}

		START_CITY = sc.nextInt();
		END_CITY = sc.nextInt();

		sc.close();

		cost = new long[N + 1];
		checked = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.MAX_VALUE - 1;
			checked[i] = false;
		}

		cost[START_CITY] = 0;

		for (int k = 0; k < N - 1; k++) {
			long min = Integer.MAX_VALUE;
			int from = -1;

			for (int i = 1; i <= N; i++) {
				if (checked[i] == false && min > cost[i]) {
					min = cost[i];
					from = i;
				}
			}

			checked[from] = true;

			for (int to = 1; to <= N; to++) {
				if (maps[from][to] != -1 && cost[from] != Integer.MAX_VALUE - 1
						&& cost[to] > cost[from] + maps[from][to]) {
					cost[to] = cost[from] + maps[from][to];
				}
			}
		}

		System.out.println(cost[END_CITY]);
	}
}
