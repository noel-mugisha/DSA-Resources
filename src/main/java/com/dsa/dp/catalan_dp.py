"""Catalan DP — Revision Template

Core recurrence:
    C[n] = sum(C[k] * C[n - 1 - k] for k in range(n))

Interpretation:
    Choose a root / split point.
    - left side has k elements
    - right side has n - 1 - k elements
    - left and right structures combine independently -> multiply
    - try every k -> add

Base case:
    C[0] = 1

Why C[0] = 1?
    There is exactly one valid empty structure: the empty structure.
    It is needed when one side of the split is empty.
"""


# ---------------------------------------------------------------------------
# 1. RECURSION + MEMOIZATION (TOP-DOWN)
# ---------------------------------------------------------------------------

def catalan_memo(n: int) -> int:
    """Return the nth Catalan number using recursion + memoization.

    Time:  O(n^2)
        There are n states, and each state loops over up to n split points.

    Space: O(n)
        Memo table + recursion stack.
    """
    memo = {0: 1}

    def solve(n: int) -> int:
        if n in memo:
            return memo[n]

        total = 0
        for k in range(n):
            left = solve(k)
            right = solve(n - 1 - k)
            total += left * right

        memo[n] = total
        return total

    return solve(n)


# ---------------------------------------------------------------------------
# 2. BOTTOM-UP TABULATION
# ---------------------------------------------------------------------------

def catalan_tabulation(n: int) -> int:
    """Return the nth Catalan number using bottom-up DP.

    Time:  O(n^2)
        dp[0..n] are computed once; each dp[i] checks i split points.

    Space: O(n)
        The DP array stores C[0..n].
    """
    dp = [0] * (n + 1)
    dp[0] = 1

    for size in range(1, n + 1):
        for k in range(size):
            dp[size] += dp[k] * dp[size - 1 - k]

    return dp[n]


# ---------------------------------------------------------------------------
# CATALAN DP — WHAT TO REMEMBER
# ---------------------------------------------------------------------------

# TEMPLATE:
#   dp[n] = sum(dp[k] * dp[n - 1 - k])
#
# BASE:
#   dp[0] = 1
#
# IMPORTANT:
#   k is the LEFT SUBSTRUCTURE SIZE, not necessarily an array index/pivot key.

# COMMON CATALAN PROBLEMS:
#   - Number of unique BSTs
#   - Full binary-tree structures
#   - Balanced parentheses counting
#   - Convex polygon triangulation
#   - Parenthesization / matrix-chain style counting
#
# INTERVIEW COMPLEXITY FOR THESE COUNTING FUNCTIONS:
#   Time:  O(n^2)
#   Space: O(n)

