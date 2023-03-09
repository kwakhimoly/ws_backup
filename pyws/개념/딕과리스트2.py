# list 안에 dict 담기

score = [
    {"name":"홍길동", "kor":90, "eng":79, "mat":98},
    {"name":"김길동", "kor":90, "eng":79, "mat":78},
    {"name":"이길동", "kor":78, "eng":90, "mat":68},
    {"name":"박길동", "kor":98, "eng":78, "mat":78},
    {"name":"윤길동", "kor":95, "eng":88, "mat":88},
    {"name":"정길동", "kor":85, "eng":83, "mat":81}
]

print(score[0]["name"], score[0]["kor"], score[0]["eng"], score[0]["mat"])
print("-----")
for i in range(0, len(score)):
    print(score[i]["name"], score[i]["kor"], score[i]["eng"], score[i]["mat"])
print("-----")
for s in score:
    print(s["name"], s["kor"], s["eng"], s["mat"])
print("-----")

# 1~100까지 한 줄에 열개씩 출력하기
# range(1,100,1) -> 100은 빠져서 99까지만 출력됨!
for i in range(1, 101, 1):
    print(i, end="\t")
    if i%10 == 0:
        print()
print("-----")

# 1~100까지 한 줄에 열개씩 출력 : 이중 for문
k = 1
for i in range(0,10):
    for j in range(0,10):
        print(k, end=" ")
        k = k+1
    print()
# i=0
# j=0, k=1
# j=1, k=2
# j=2, k=3
# j=3, k=4
# j=4, k=5
# j=5, k=6
# j=6, k=7
# j=7, k=8
# j=8, k=9
# j=9, k=10
# print()
# i=1
# j=0, k=11