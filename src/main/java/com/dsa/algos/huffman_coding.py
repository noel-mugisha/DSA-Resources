import heapq
from collections import Counter


class Node:
    def __init__(self, char, freq):
        self.char = char
        self.freq = freq
        self.left = None
        self.right = None


class HuffmanCoding:

    def __init__(self):
        self.root = None
        self.codes = {}

    def build_tree(self, data: str) -> Node:
        counts = Counter(data)
        heap = []
        counter = 0

        for key, value in counts.items():
            node = Node(key, value)

            # counter is used to determine priority if frequencies
            # are equal because Python cannot compare Node objects.
            heap.append((value, counter, node))
            counter += 1

        heapq.heapify(heap)

        while len(heap) > 1:
            freq1, _, left = heapq.heappop(heap)
            freq2, _, right = heapq.heappop(heap)

            merged = Node(None, freq1 + freq2)
            merged.left = left
            merged.right = right

            heapq.heappush(
                heap,
                (merged.freq, counter, merged)
            )

            counter += 1

        _, _, root = heapq.heappop(heap)

        return root

    def generate_codes(
        self,
        node: Node,
        code: str = ""
    ) -> None:

        if not node:
            return

        # We reached a leaf.
        if not node.left and not node.right:
            self.codes[node.char] = code if code else "0"
            return

        self.generate_codes(
            node.left,
            code + "0"
        )

        self.generate_codes(
            node.right,
            code + "1"
        )

    def fit(self, data: str) -> None:
        """
        Build the Huffman tree and generate the codes
        for the given data.
        """

        if not data:
            raise ValueError("Cannot build a Huffman tree from empty data.")

        self.root = self.build_tree(data)

        self.codes = {}

        self.generate_codes(self.root)

    def encode(self, data: str) -> str:

        if not self.codes:
            raise ValueError(
                "Huffman codes have not been generated. "
                "Call fit() first."
            )

        result = []

        for char in data:
            result.append(self.codes[char])

        return "".join(result)

    def decode(self, encoded: str) -> str:

        if self.root is None:
            raise ValueError(
                "Huffman tree has not been built. "
                "Call fit() first."
            )

        # Edge case: tree contains only one character.
        if self.root.left is None and self.root.right is None:
            return self.root.char * len(encoded)

        result = []
        current = self.root

        for bit in encoded:

            if bit == "0":
                current = current.left
            else:
                current = current.right

            # We reached a leaf.
            if current.left is None and current.right is None:
                result.append(current.char)
                current = self.root

        return "".join(result)


if __name__ == "__main__":

    s = (
        "ABECADFBEACFDBEACFBEACDFBAECDABFCEABDCEABDCEABD"
        "CEABDCEABDCEABDCEABDCEABDCEABDCEABDCEABDCEABDCE"
    )

    huffman = HuffmanCoding()

    # Build tree + generate codes
    huffman.fit(s)

    # Encode
    encoded = huffman.encode(s)

    print("\nOriginal:")
    print(s)

    print("\nEncoded:")
    print(encoded)

    # Decode
    decoded = huffman.decode(encoded)

    print("\nDecoded:")
    print(decoded)

    # Verify
    print("\nCorrect:", decoded == s)