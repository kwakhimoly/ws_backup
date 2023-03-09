# 기본값
# 오버로딩 안 된다. 함수의 이름이 같은데 형태가 다른 함수를 못 만든다.
# 대신에 매개변수에 기본값을 부여하여 마치 오버로딩과 동일한 효과를 가져온다

def myadd(a=10, b=20, c=30):
    return a+b+c

print(myadd()) # 60
print(myadd(1)) # a=1이 적용되고 b=20,c=30이 적용된다. 51
print(myadd(1,2)) # a=1,b=2이 적용되고 c=30이 적용된다. 33
print(myadd(1,2,3)) # a=1,b=2,c=3이 적용된다. 6

print(myadd(b=100, a=20))

print(1,2,3, sep="*", end=" ")
print(4,5,6,7, sep="*")

# 함수의 인수를 dict 타입({}: 안되는듯~)으로 받고 싶을 때 변수 앞에 **을 붙인다.
def myfunc(**info):
    for key in info.keys():
        print(key, info[key])

myfunc(url="www.naver.com", port=1521, param="x")

# 재귀함수: 자기가 자기를 호출한다.
#           트리순회, inorder/postorder/preorder 순회할 때
#           수식 전환 시 유용
#           재귀호출을 쓰는 이유는 코드가 간결하다.
#           단점: 느리고, 메모리를 많이 차지함. 그리고 잘못하면 스택 오버 플로우 문제가 발생한다.
#     퀵정렬 : 자바로 구현하면 시스템 자원을 백프로 사용을 못해서 오류발생할 가능성이 높다.

# 1+2+3+4...+10 을 재귀호출로 만들어 보자.
"""
    f(n) = n + f(n-1)
"""
def sigma(n=10):
    print(n)
    if(n==1):
        return 1
    return n+sigma(n-1)
print(sigma())
print(sigma(100))

def myfunction():
    pass
# pass 구문 : 아직 내용이 확정되지 않았을 때 임시로 작성(나중에 처리하려고)
#           class, 함수, if, for, while 아무 곳이나 사용 가능

# print 함수의 도움말 보기
# __ 로 시작하는 변수, 혹은 함수는 특수목적임. 보통 private 접근 권한
print(print.__doc__) # = 설명서
