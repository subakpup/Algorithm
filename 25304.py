import sys
input = sys.stdin.readline

x = int(input())
total = 0

for i in range(int(input())):
    a,b = map(int,input().split())
    total += a*b

if total == x:
    print("Yes")
else:
    print("No")