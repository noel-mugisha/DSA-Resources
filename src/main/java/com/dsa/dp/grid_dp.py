def uniquePathsWithObstacles(obstacleGrid: list[list[int]]) -> int:
    if obstacleGrid[0][0] == 1:
        return 0
    ROWS, COLS = len(obstacleGrid), len(obstacleGrid[0])
    dp = [0] * COLS
    dp[0] = 1

    for r in range(ROWS):
        for c in range(COLS):
            if obstacleGrid[r][c] == 1:
                dp[c] = 0
                continue

            if c > 0:
                dp[c] += dp[c - 1]

    return dp[-1]