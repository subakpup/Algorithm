import sys
input = sys.stdin.readline

while True:
    arr = list(map(int,input().split()))
    if arr[0] == arr[1] == arr[2] == 0:
        break
    arr.sort()
    print("right" if arr[0]**2 + arr[1]**2 == arr[2]**2 else "wrong")