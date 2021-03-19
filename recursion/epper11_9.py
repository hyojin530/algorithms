#https://level.goorm.io/exam/109220/11%ED%9A%8C-e-pper-9-%EC%98%AC%EB%B0%94%EB%A5%B8-%EA%B4%84%ED%98%B8-%EB%B0%B0%EC%97%B4/quiz/1

import sys

n = int(sys.stdin.readline())

def solution(left, right):
	if(left==0):
		return 1
	elif(left<right):
		return solution(left-1, right) + solution(left, right-1)
	elif(left==right):
		return solution(left-1, right)
	
output = solution(n, n)

print(output)