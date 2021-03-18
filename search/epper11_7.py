#https://level.goorm.io/exam/109219/11%ED%9A%8C-e-pper-7-%EB%8B%A8%EC%88%9C-%EA%B3%84%EC%82%B0%EA%B8%B0/quiz/1

import sys


def insert_sort(n):
	for i in range(1, len(n)):
		j = i-1
		while(j>=0 and n[i]<n[j]):
			j -= 1
		n.insert((j+1), n[i])
		del n[i+1]
	return n



n = int(sys.stdin.readline())
data = []

for i in range(n):
	x = int(sys.stdin.readline())
	data.append(x)
	
sorted_data = insert_sort(data)
temp_avg = 0

for i in range(0, len(data)):
	if (temp_avg == 0):
		temp_avg = data[i]
		continue
	
	temp_avg = (temp_avg+data[i])/2

print(f'{temp_avg:.6f}')