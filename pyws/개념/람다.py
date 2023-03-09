a = [1,3,4,5,6,7,8,9,10,11,13,12,21,52,64]
colors = ["red", "orange", "yellow", "green", "blue",\
          "navy", "purple", "white", "black"]
dataList = [
    {"name":"홍길동", "age":23, "phone":"010-0001-0001"},
    {"name":"김길동", "age":24, "phone":"010-0001-0002"},
    {"name":"이길동", "age":25, "phone":"010-0001-0003"},
    {"name":"박길동", "age":26, "phone":"010-0001-0004"},
    {"name":"최길동", "age":27, "phone":"010-0001-0005"},
    {"name":"정길동", "age":28, "phone":"010-0001-0006"},
    {"name":"한길동", "age":29, "phone":"010-0001-0007"},
    {"name":"장길동", "age":30, "phone":"010-0001-0008"},
    {"name":"안길동", "age":31, "phone":"010-0001-0009"},
    {"name":"신길동", "age":32, "phone":"010-0001-0010"}
]

# 람다 : 파이썬의 경우에 한줄짜리 함수. 쓰고 버리는 임시 함수
# 파이썬의 경우-> lambda 매개변수 : 수식

# a로부터 짝수를 걸러내려 한다.
# filter : 특정 조건을 만족하는 데이터리스트를 만들 때 사용
# map : 배열의 모든 요소에 연산을 실행할 때 사용
# zip : 여러 개의 배열의 요소를 묶어서 tuple로 만들 때 사용

# filter : 매개변수가 하나이고 반환값은 true 혹은 false인 함수를 전달하면 이 함수를 배열의 요소마다 호출하여 true인 데이터만 반환
def isEven(x):
    return x%2==0
b = filter(isEven, a)   # filter(함수, iterable객체)
# 이 때 filter가 실행되는 것이 아니라 iterable객체를 반환
# for문이나 list를 다시 사용해야 한다.
print(b)

# 둘 중 하나 쓰기
b=list(filter(isEven,a))
print(b)
for i in filter(isEven, a):
    print(i, end=" ")
print()
# 함수를 람다로 만들어 전달하기
# a라는 리스트의 요소들이 x로 전달된다.
for i in filter(lambda x: x%2==0, a):
    print(i, end=" ")
print()
# 문자열: 단어길이가 5글자 이상인 경우만 추출하기
for i in filter(lambda w : len(w)>=5, colors):
    print(i, end=" ")
print()
for i in map(lambda w : w.upper(), colors):
    print(i, end=" ")
print()
wordList = sorted(colors, key=lambda x : x)
print("정렬된 데이터")
print(wordList)
print("원본 데이터")
print(colors)

sortedDataList = sorted(dataList, key=lambda item:item["name"])
print("정렬된 dataList")
for item in sortedDataList:
    print(item)
print("원본 dataList")
for item in dataList:
    print(item)

print("sort 함수")
# sort 함수 : 원본이 정렬됨
dataList.sort(key=lambda item:item["name"], reverse=True)
for item in dataList:
    print(item)

# zip : 여러 개의 데이터를 한 묶음으로 만든다.
# 남는 데이터의 경우 알아서 버림
list1 = ["홍길동", "김길동", "박길동", "이길동"]
list2 = ["hong@mail.com", "kim@mail.com", "park@mail.com"]
list3 = ["111", "222", "333"]

for item in zip(list1, list2, list3):
    print(item) # 각각의 요소들을 tuple로 묶어서 전달