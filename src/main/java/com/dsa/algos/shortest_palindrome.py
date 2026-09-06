class Solution:
    def shortestPalindrome(self, s: str) -> str:
        base, mod = 256, 10**9 + 7
        forward_hash = reverse_hash = 0
        longest, power = 0, 1

        for i, c in enumerate(s):
            val = ord(c)

            forward_hash = (forward_hash * base + val) % mod
            reverse_hash = (power * val + reverse_hash) % mod

            power = (power * base) % mod

            if forward_hash == reverse_hash:
                longest = i

        suffix = s[longest + 1: ]
        return suffix[::-1] + s