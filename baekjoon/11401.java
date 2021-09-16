//https://www.acmicpc.net/problem/11401

import java.util.Scanner;

public class Main {
	static int MOD = 1000000007;
	
	static long factorial(long n) {
		long ans = 1;
		
		for(long i = n; i > 0; i--) {
			ans = (ans * i) % MOD;
		}
		
		return ans;
	}
	
	static long pow(long a, int b) {
		long ans = 1;
		long m = a;

		while(b > 0) {
			if(b%2 == 1) {
				ans = (ans*m) % MOD;
			}
			
			b = b/2;
			m = (m*m) % MOD;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long k = sc.nextInt();
		
		long a = factorial(n);
		long b = (factorial(n-k)*factorial(k)) % MOD;
		
		long result = (a * pow(b, MOD-2)) % MOD;
		
		System.out.println(result);
	}
}
