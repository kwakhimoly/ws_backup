#dict 타입은 dictionnary의 약자, 자바의 hashmap과 유사
#idndexing이나 슬라이싱 안 됨. 키와 값 쌍의 형태로 값을 저장한다.

mydic = {"red":"빨간색", "green":"초록색", "blue":"파란색"}
print(mydic["red"])
# print(mydic.green) 사용불가!
print(mydic["blue"])

#추가
mydic["black"]="검은색"
print(mydic)

#수정
mydic["red"]="빨강색"
print(mydic)

#삭제
del mydic["red"]
print(mydic)