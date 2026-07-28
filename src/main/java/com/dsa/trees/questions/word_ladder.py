from collections import deque
from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0

        q = deque([beginWord])
        level = 0

        while q:
            level_len = len(q)

            for _ in range(level_len):
                word = q.popleft()
                for i in range(len(word)):
                    for j in range(26):
                        c = chr(ord('a') + j)
                        new_word = word[:i] + c + word[i+1:]

                        if new_word == endWord:
                            return level + 1

                        if new_word in word_set:
                            q.append(new_word)
                            word_set.remove(new_word)

            level += 1

        return 0
