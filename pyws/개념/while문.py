"""
한번도 수행이 안 될 가능성이 있을 때
한번 이상 수행이 될 때는 do~ 파이썬은 do, switch 없음
    while 조건식:
        코드
for : 몇번 수행할지 알 수 있는 경우에

현재 나오는 언어들은 그냥 맘대로 써도 된다.
"""

i = 1
while i<=10:
    print(i, end=" ")
    i = i+1
print()
# 정수를 입력받아 합계랑 평균을 구한다.
# 마지막에 음수가 입력된다.
# sum = 0
# cnt = 1
# while i>0:
#     i = int(input("종료 시 음수 입력\n"))
#     if(i<0):
#         break
#     sum = sum+i
#     print("합= ",sum)
#     print("평균= ",sum/cnt)
#     cnt = cnt+1
dataList=[]
num = int(input("정수: "))
while num>=0:
    dataList.append(num)
    num= int(input("정수: "))
print(sum(dataList))
print(sum(dataList)/len(dataList))