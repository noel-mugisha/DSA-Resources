
# Recursion + memoization solution
def canPartition(self, nums: list[int]) -> bool:
    sum_ = sum(nums)
    if sum_ % 2 != 0:
        return False

    target_sum = sum_ / 2

    @lru_cache(None)
    def dfs(i, target):
        if target == 0:
            return True
        if i == len(nums):
            return False

        if nums[i] <= target:
            return dfs(i + 1, target - nums[i]) or dfs(i + 1, target)

        return dfs(i + 1, target)

    return dfs(0, target_sum)

# Solve using 2DP tabulation
def canPartitionII(self, nums: list[int]) -> bool:
    sum_ = sum(nums)
    if sum_ % 2 != 0:
        return False

    target_sum, n = sum_ // 2, len(nums)

    dp = [[False] * (target_sum + 1) for _ in range(n + 1)]
    for i in range(n + 1):
        dp[i][0] = True

    for i in range(1, n + 1):
        for curr_sum in range(1, target_sum + 1):
            skip = dp[i - 1][curr_sum]

            if nums[i - 1] <= curr_sum:
                take = dp[i - 1][curr_sum - nums[i - 1]]
                dp[i][curr_sum] = take or skip
            else:
                dp[i][curr_sum] = skip

    return dp[n][target_sum]

# Solved using 1DP tabulation
def canPartitionIII(self, nums: list[int]) -> bool:
    sum_ = sum(nums)
    if sum_ % 2 != 0:
        return False

    target_sum, n = sum_ // 2, len(nums)

    dp = [False] * (target_sum + 1)
    dp[0] = True

    for i in range(n):
        for curr_sum in range(target_sum, nums[i] - 1, -1):
            dp[curr_sum] = dp[curr_sum - nums[i]] or dp[curr_sum]

    return dp[target_sum]
