import sys
input = sys.stdin.readline

n = int(input())
dp = [1] * n
arr = [list(map(int,input().split())) for _ in range(n)]
arr.sort()

for i in range(1,n):
    for j in range(i):
        if arr[i][1] > arr[j][1]:
            dp[i] = max(dp[i], dp[j]+1)

print(n - max(dp))