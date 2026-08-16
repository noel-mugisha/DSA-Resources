class RabinKarp:
    def rabin_karp(self, text: str, pattern: str) -> int:
        m, n = len(text), len(pattern)
        if n > m:
            return -1

        base, mod = 256, 1_000_000_007

        highest_power = 1
        for _ in range(n - 1):
            highest_power = (highest_power * base) % mod

        window_hash, pattern_hash = 0, 0
        for i in range(n):
            pattern_hash = (pattern_hash * base + ord(pattern[i])) % mod
            window_hash = (window_hash * base + ord(text[i])) % mod

        for i in range(m - n + 1):
            if pattern_hash == window_hash:
                is_match = True
                for j in range(n):
                    if pattern[j] != text[i + j]:
                        is_match = False
                        break

                if is_match:
                    return i

            if i < m - n:
                outgoing, incoming = ord(text[i]), ord(text[i + n])
                window_hash = (window_hash - (highest_power * outgoing)) % mod
                window_hash = (window_hash * base + incoming) % mod

        return -1
