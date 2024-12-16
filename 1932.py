import sys
input = sys.stdin.readline

def func(n):
    for i in range(1,n):
        for j in range(i+1):
            if j == 0:
                dp[i][j] += dp[i-1][j]
            elif j == i:
                dp[i][j] += dp[i-1][j-1]
            else:
                dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])

if __name__ == "__main__":
    n = int(input())
    dp = [list(map(int,input().split())) for _ in range(n)]
    func(n)
    print(max(dp[-1]))