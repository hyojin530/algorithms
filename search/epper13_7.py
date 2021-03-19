#https://level.goorm.io/exam/109224/13%ED%9A%8C-e-pper-7-palindrome%EC%9D%84-%EB%A7%8C%EB%93%A4%EA%B8%B0%EA%B9%8C%EC%A7%80%EC%9D%98-%ED%9A%9F%EC%88%98/quiz/1#

import sys

n = int(sys.stdin.readline())

data = list(map(int, sys.stdin.readline().split()))

i = 0
output = 0

def modify(a, n, m):
	a[n] = a[n] + a[m]
	del a[m]
	return a

while(True):
	if (i > int(len(data)/2)):
		break
	else:
		while(data[i] != data[n-1-i]):
			if (data[i] < data[n-1-i]):
				data = modify(data, i, i+1)
				output += 1
			else:
				data = modify(data, n-1-i, n-2-i)
				output += 1
			n = len(data)
	i += 1

print(output)