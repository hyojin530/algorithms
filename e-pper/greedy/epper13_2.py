#https://level.goorm.io/exam/111406/13%ED%9A%8C-e-pper-2-%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88-%EA%B3%84%EC%82%B0/quiz/1

import sys

payment = int(sys.stdin.readline())
price = int(sys.stdin.readline())

change = payment-price

money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
kind = 0
nums = 0

for m in money:
	if (m > change):
		continue
	else:
		nums += int(change/m)
		kind += 1
		change = change % m
		
print(f'{kind} {nums}')