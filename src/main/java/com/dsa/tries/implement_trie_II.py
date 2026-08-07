class TrieNode:
    def __init__(self):
        self.children = {}
        self.prefix_count = 0
        self.word_count = 0


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root

        for c in word:
            if c not  in curr.children:
                curr.children[c] = TrieNode()

            curr.children[c].prefix_count += 1
            curr = curr.children[c]

        curr.word_count += 1

    def countWordsEqualTo(self, word: str) -> int:
        curr = self.root

        for c in word:
            if c not in curr.children:
                return 0

            curr = curr.children[c]

        return curr.word_count

    def countWordsStartingWith(self, prefix: str) -> int:
        curr = self.root

        for c in prefix:
            if c not in curr.children:
                return 0

            curr = curr.children[c]

        return curr.prefix_count

    def erase(self, word: str) -> None:
        curr = self.root

        for c in word:
            curr = curr.children[c]

            curr.prefix_count -= 1

        curr.word_count -= 1

