a,b,c = map(int,(input(),input(),input()))
if a == 60 and b == 60 and c == 60:
    print("Equilateral")
elif a+b+c == 180 and (a == b or b == c or a == c):
    print("Isosceles")
elif a+b+c == 180:
    print("Scalene")
else:
    print("Error")