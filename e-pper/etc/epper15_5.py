#https://level.goorm.io/exam/100821/15%ED%9A%8C-epper-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%95%95%EC%B6%95/quiz/1

import sys

input = sys.stdin.readline()
output = ''
temp = '0'

if(input[0]=='1'):
	output += '1'
	temp = '1'

ch = ord('A')-1
for i in input:
	if temp == i:
		ch += 1
	else:
		output += chr(ch)
		temp = i
		ch = ord('A')

output += chr(ch)
print(output)