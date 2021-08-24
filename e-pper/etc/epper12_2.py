#https://level.goorm.io/exam/109213/12%ED%9A%8C-e-pper-2-%EB%B0%A9-%EB%B2%88%ED%98%B8%EC%99%80-%EB%B0%A9-%EC%95%88-%EB%B2%88%ED%98%B8/quiz/1

import sys

input = int(sys.stdin.readline())
room = 0
order = 0

if(input%15==0):
	room = input/15
	order = 15
else:
	room = input/15 + 1
	order = input%15
	
print(f'{int(room)} {int(order)}')