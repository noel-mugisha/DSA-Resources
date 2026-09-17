from functools import lru_cache


# Solved using recursion + memoization
def unbounded_knapsack(weights, values, capacity):
    n = len(values)

    @lru_cache(None)
    def dfs(i, remaining):
        if remaining == 0:
            return 0
        if i == n:
            return 0

        skip = dfs(i + 1, remaining)
        take = 0

        if weights[i] <= remaining:
            take = values[i] + dfs(i, remaining - weights[i])

        return max(skip, take)

    return dfs(0, capacity)

# Solved using 2D tabulation
def unbounded_knapsackII(weights, values, capacity):
    n = len(values)
    dp = [[0] * (capacity + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for w in range(1, capacity + 1):
            skip = dp[i - 1][w]
            take = 0

            if weights[i - 1] <= w:
                take = values[i - 1] + dp[i][w - weights[i - 1]]

            dp[i][w] = max(take, skip)

    return dp[n][capacity]


# Solved using 1DP tabulation
def unbounded_knapsackIII(weights, values, capacity):
    dp = [0] * (capacity + 1)

    for i in range(len(values)):
        for c in range(weights[i], capacity + 1):
            skip = dp[c]
            take = values[i] + dp[c - weights[i]]

            dp[c] = max(skip, take)

    return dp[capacity]