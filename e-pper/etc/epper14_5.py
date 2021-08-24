#https://level.goorm.io/exam/109221/14%ED%9A%8C-e-pper-5-%EB%8B%A8%EC%96%B4-%EA%B2%8C%EC%9E%84/quiz/1#

import sys

word_num, game_num = map(int, sys.stdin.readline().split())
word_list = []
game_list = []

for i in range(word_num):
	word_list.append(sys.stdin.readline().split()[0])

for i in range(game_num):
	game_list.append(sys.stdin.readline().split()[0])

sorted_list = sorted(word_list)
word_dict = { word: 0 for word in sorted_list}


output = []
for char in game_list:
	min_word = ''
	min_num = -1
	for word in sorted_list:
		if(char == word[0]):
			if(min_num == -1):
				min_num = word_dict[word]
				min_word = word
			elif(min_num > word_dict[word]):
				min_num = word_dict[word]
				min_word = word
	output.append(min_word)
	word_dict[min_word] += 1

for word in output:
	print(word)