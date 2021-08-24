#https://level.goorm.io/exam/100917/%EB%8F%84%EC%84%9C%EA%B4%80-%EC%A2%8C%EC%84%9D-%EC%98%88%EC%95%BD/quiz/1

import sys

num = int(sys.stdin.readline())
start = list(map(int, sys.stdin.readline().split()))
end = list(map(int, sys.stdin.readline().split()))

def insert_sort(data, sub):
	for i in range(1, len(data)):
		j = i-1
		while(j>=0 and data[j]>data[i]):
			j -=1
		data.insert(j+1, data[i])
		sub.insert(j+1, sub[i])
		del data[i+1]
		del sub[i+1]
	
	return data, sub

end_sorted, start_sorted = insert_sort(end, start)


seat1 = -1
seat2 = -1
output = 0

for i in range(0, len(start)):
	if(seat1 <= start_sorted[i]):
		seat1 = end_sorted[i]
		output += 1
	elif(seat2 <= start_sorted[i]):
		seat2 = seat1
		seat1 = end_sorted[i]
		output += 1
		
print(output)