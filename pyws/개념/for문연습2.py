# 구구단
# "형식"%(튜플)
#  -> 2.대 버전 때 썼던 형식화 문자열
for i in range(1,10):
    print("%s x %d = %d" % (3,i,3*i))
print("---")
# 서식 : format 함수
for i in range(1, 10):
    print("{} x {} = {}".format(3,i,3*i))
print("---")
# 서식 : f-string 함수
for i in range(1,10):
    print(f"{i} x {3} = {3*i}")
print("---")

# ()안 숫자들의 위치값으로 소환(0번째=10, 1번쩨=20, 2번째=30)
print("{0} {1} {2} {0} {2}".format(10, 20, 30))

# 자릿수 10칸을 차지하고 공백을 앞에 붙인다.
print("{:>10}**".format(5)) #   오른쪽 정렬
print("{:<10}**".format(5)) #   왼쪽 정렬
print("{:^10}**".format(5)) #   중앙 정렬

# 소숫점 이하 자릿수
print("{:.2}**".format(10/3))   #   소수점 이하 2자릿수째에 반올림해서 출력 (.2 : 소숫점 한자리수까지 출력 ,.3 : 소숫점 두자리수까지 출력)
print("{:,}".format(100000000000))  #   3자리 수마다 , 

print("---")

# 문제
"""
ABCDEFGHIJKELMNOPQRSTUVWXYZ
BCDEFGHIJKELMNOPQRSTUVWXYZA
CDEFGHIJKELMNOPQRSTUVWXYZAB
"""

s = "ABCDEFGHIJKELMNOPQRSTUVWXYZ"
for i in range(0,26):
    print(s)
    s = s[1:]+s[0]

print("---")

# 이중 for문
for i in range(3,6):
    for j in range(1,10):
        print(f"{i}x{j}={i*j}")

print("---")

# break와 continue문
for i in range(1, 11):
    print(i)
    if(i==5):
        break # i 값이 5일 때 for문 종료
print("---")

for i in range(1,11):
    if i==5:
        continue # 특정 조건을 만족하면 다음 문장들을 수행하지 않고 
                # 루프로 되돌아간다.
    print(i)
print("---")

flag = False
for i in range(1, 11):
    print(i)
    if i==5:
        flag=True
        break
if flag:
    print("break문 통해서 나옴")
else:
    print("종료")

for i in range(1,11):
    print(i)
    if i==5:
        break
    else:
        print("break 구문 없음")
print("----")

a = [
    [1,2,3],
    [4,5,6]
]

print(a[0][0])
print(a[0][1])
print(a[0][2])
print()
print(a[1][0])
print(a[1][1])
print(a[1][2])