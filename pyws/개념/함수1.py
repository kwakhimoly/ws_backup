# 함수 아무데서나 만들어도 된다.
# 전역함수(클래스 밖에 만든 함수)

def add(x,y):
    return x+y

print(add(5,4))

x=10
y=20
print(add(x,y))

# 함수의 주소를 다른 변수에 저장한다.
calc = add # add가 갖고 있는 함수의 주소를 calc 변수에 저장가능
print(calc(11,22)) # java는 인터페이스로 대신 처리한다.

# 1~limit까지의 합계를 구하여 반환하는 함수
def sigma(limit):
    if limit<1: # 함수를 sigma(0)으로 호출하면 0이 limit보다 작아서 None을 반환하고 종료한다.
        return # 값을 보내지 않을 경우 None이 반환된다
    
    s=0
    for i in range(1, limit+1):
        s += i
    return s

print(sigma(0))
print(sigma(10))
print(sigma(100))

def isZero(args1):
    return args1==0 # == : 연산 수행 결과를 반환
print(isZero(7))
print(isZero(0))

# 매개변수로 전달했을 때 값이 변경 가능한 경우는 list나 dict으로 전달했을 때
def changeValue(a):
    a = a*10
    return a

x = 11 

# x가 생성되는 영역과 a가 생성되는 영역은 서로 다르다
# 함수가 호출될 때 x 변수에 저장된 값이 a 변수로 복사된다.
# a 변수의 값을 바꾸어도 x 변수와 a 변수는 서로 다른 메모리 공간을 차지하기 때문에 서로 영향을 미치지 않는다.

x = changeValue(x)
print("x= ", x)


# list, dict 타입은 직접 변경 가능
a = [0,0,0,0,0]
def setValue(aa):
    for i in range(0, len(aa)):
        aa[i] = i+1

setValue(a)
# list 타입이 전달되면 list 타입은 값을 바꿔서 온다
# heap 공간에 데이터를 저장하기 때문에 함수에 주소값만 전달 -> 함수가 직접 값을 변경
print(a)

def setDictValue(colors):
    colors["red"]="빨강색"
    colors["green"]="초록색"
    colors["blue"]="파랑색"

out_colors={} # dict 객체 생성 {} 또는 dict()
setDictValue(out_colors)
print(out_colors)

# 짝수 홀수 구분

a = [3,6,7,8,9,11,12,16,123,14,64]

oddList=[]
evenList=[]

for i in a:
    if i%2==0:
        evenList.append(i)
    else:
        oddList.append(i)
print(oddList)
print(evenList)

print("홀수만 추출")
print([i for i in a if i%2==1])
print("짝수만 추출")
print([i for i in a if i%2==0])