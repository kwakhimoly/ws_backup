words = ["apple", "banana", "cherry", "peach", "pineapple", "orange"]

print(words)

# 인덱싱과 슬라이싱 지원

print(words[0])
print(words[1])
print(words[2])

print(words[:3]) #0,1,2
print(words[:3:2]) #0,2
print(words[::-1]) #역순으로 출력
print(words[3:]) #3,4,5...

#list 타입은 인덱싱과 슬라이싱을 통해 값 변경 가능
words[0]="grape"
print(words)

words[1:3]=["red", "blue"]
print(words)

#데이터 추가
words.append("strawberry")
words.append("tomato")
print(words)

#데이터 삭제
words.remove("red")
print(words)

#데이터 확장: 두 개의 리스트 합치기
words.extend(["citron"]) # 꼭 () 안에 배열을 넣어줘야 함. ("blue") 이렇게 넣을 경우 ["b", "l", "u", "e"] 이렇게 들어감
print(words)

#특정 데이터의 위치값 찾기
print(words.index("citron"))
# 찾아서 있으면 위치 값을 반환, 없으면 예외 발생

# 데이터 개수를 세서 반환. 이 값이 9이면 존재 안 함
print(words.count("citron"))

if words.count("red")==0:
    print("red doesn't exist")
else:
    print(words.index("red"))

if "peach" in words : # list 안에 데이터가 있으면 true, 없으면 false
    print("peach is founded!")
    print(words.index("peach"))
else:
    print("peach is not founded")

if "blue" not in words:
    print("blue isn't founded")
else:
    print("blue does exist")