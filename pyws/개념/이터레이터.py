s = "Hello"

# 이터레이터 : 사용자가 실제로 내부의 데이터 배치 방법을 몰라도 항상 같은 방법으로 내부 데이터에 접근하게 하기 위한 것
it = iter(s)
print(next(it))
print(next(it))
print(next(it))
print(next(it))
print(next(it))

print("--------")

a = [1,2,3,4,5]
ait = iter(a)
print(next(ait))
print(next(ait))
print(next(ait))
print(next(ait))
print(next(ait))

# => tuple, list, dict 타입 다 된다.
print("--------")

def generator(): # 무한 숫자 생성 함수
    i=1
    while True:
        # return i
        yield i # 함수를 호출하면 여기까지의 일을 저장하고 값을 보낸다. 
        # -> 원래 함수는 함수의 호출이 끝나면 메모리 정리 작업이 이루어짐, i가 없어져야 함.
        # yield를 쓰면 함수가 값은 보내지만 정리되지 않음. 메모리를 차지한 채로 유지.
        i = i+1

print(generator()) # generator 주소 호출

# for i in generator():
#     print(i)

def generator2(limit=10):
    i=1
    while i<=limit:
        yield i
        i = i+1

print("--------")

print("2번째 제너레이터")
for i in generator2():
    print(i)

print("--------")

g = generator2()
print(next(g))
print(next(g))
print(next(g))
print(next(g))
print(next(g))