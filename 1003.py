import sys
input = sys.stdin.readline

for i in range(int(input())):
    zero = [1,0,1]
    one = [0,1,1]
    n = int(input())
    if n > 2:
        for i in range(3,n+1):
            zero.append(zero[i-1]+zero[i-2])
            one.append(one[i-1]+one[i-2])
    print(f'{zero[n]} {one[n]}')