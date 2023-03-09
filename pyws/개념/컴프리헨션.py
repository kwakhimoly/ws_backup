a = [1,3,4,5,6,7,8,9,10,11,13,12,21,52,64]
# 위에 있는 리스트를 복사
b = a 
# 얕은 복사와 깊은 복사
# 파이썬은 모든 변수가 참조이다.
# 변수에 저장되는 값은 참조(주소)이다.
# b = a : b 변수에는 a가 갖고 있는 주소값이 복사된다. 
# 둘이 같은 객체를 가리킨다.

b[0] = 100  # b = a : 얕은 복사()
print("a= ", a)
print("b= ", b)

# 깊은 복사 : 새로운 메모리를 확보하고 데이터를 복사하기 
b = [] # 새로운 리스트를 만든다.
       # b = list()로도 쓸 수 있음
for i in range(0,len(a)):
    b.append(a[i])
b[0] = -3
print("a= ", a)
print("b= ", b)

# 컴프리헨션 
# 항목 변수명은 같아야함!
# [항목 for 항목 in 리스트]
# [항목 for 항목 in 리스트 if 조건식] : 조건식을 만족하는 리스틈나 복사해서 전달. 조건식을 만족하지 못할 경우 버린다.
c = [item for item in a] # 전체 복사(깊은 복사)
print("c= ", c)

d = [item*2 for item in a]
print("d= ", d)

print("짝수만")
c = [things for things in a  if things%2==0]
print("c= ", c)

print("10보다 큰 수만")
c = [thing for thing in a  if thing>10]
print("c= ", c)

# \ : 줄바꿀 때 표시
colors = ["red", "orange", "yellow", "green", "blue",\
          "navy", "purple", "white", "black"]

# 깊은 복사
c = [x for x in colors]
print("c= ",c)

# 대문자로 바꾸어서 복사
c = [x.upper() for x in colors]
print("c = ",c)

# 문자길이가 5글자 이상만 대문자로 바꾸어서
c = [x.upper() for x in colors if len(x)>=5]
print("c= ",c)

# 문자열 안에 b라는 글자를 포함한 단어만 
c = [x for x in colors if x.__contains__("b")]
print("c= ", c)

# 단어에서 3글자씩만 잘라서 복사하기 -> 슬라이싱 활용
c = [x[:3] for x in colors]
print("c= ", c)

# list에 dict 타입 저장, pandas 라이브러리에 dataframe
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

dataList2 = [item for item in dataList]
for item in dataList2:
    print(item)

# 나이가 30이 넘어가는 사람들 목록만 추출
dataList2 = [i for i in dataList if i["age"] >= 30] # i.get("age") 도 됐음
for i in dataList2:
    print("30살=", i)

# 전화번호에 9가 들어가는 사람들 목록만 추출
dataList2 = [t for t in dataList if t["phone"].__contains__("9") ]
print("9번=", dataList2)

# 성이 장 또는 홍인 사람 추출
dataList2 = [m for m in dataList if m["name"].startswith("장") or m.get("name").startswith("홍")]
for m in dataList2:
    print("성= ",m)