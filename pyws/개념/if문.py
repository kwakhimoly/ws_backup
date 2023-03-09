# 나이를 입력받아 성인여부 판단하기
age = int(input("나이를 입력하세요\n"))
if age>=19:
    print("성인입니다")
else:
    print("미성년자입니다")

score = int(input("성적을 입력하세요\n"))
if score>=90:
    print("A")
elif score>=80:
    print("B")
elif score>=70:
    print("C")
elif score>=60:
    print("D")
else:
    print("F")