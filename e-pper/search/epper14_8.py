#https://level.goorm.io/exam/109222/14%ED%9A%8C-e-pper-8-%ED%86%A0%EB%A7%88%ED%86%A0-%EB%B3%B4%EA%B4%80/quiz/1

import sys

n, m = map(int, sys.stdin.readline().split())
data = []

for i in range(m):
	data.append(list(map(int, sys.stdin.readline().split())))

tmt = []
nums = 0

for i in range(0, m):
	for j in range(0, n):
		if(data[i][j] == 1):
			tmt.append([i, j])
		elif(data[i][j] == 0):
			nums += 1

x = 0
y = 0

while(len(tmt)!=0):
	temp = tmt[0]
	del tmt[0]
	x = temp[0]
	y = temp[1]
	
	if(x-1>=0):
		if(data[x-1][y] == 0):
			data[x-1][y] = data[x][y]+1
			tmt.append([x-1, y])
			nums -= 1
	if(y-1>=0):
		if(data[x][y-1] == 0):
			data[x][y-1] = data[x][y]+1
			tmt.append([x, y-1])
			nums -= 1
	if(x+1<m):
		if(data[x+1][y] == 0):
			data[x+1][y] = data[x][y]+1
			tmt.append([x+1, y])
			nums -= 1
	if(y+1<n):
		if(data[x][y+1] == 0):
			data[x][y+1] = data[x][y]+1
			tmt.append([x, y+1])
			nums -= 1

if (nums==0): print(data[x][y]-1)
else: print(-1)