# -*- coding: utf-8 -*-
# 에디터가 utf-8로 설정이 안 되어 있어도 강제로 인코딩을 utf-8로 바꾼다. 반드시 첫 줄에 있어야 함
print("Hello python")

a = 10
# a 자신은 참조이다. 타입이 없다. a라는 변수에 저장된 값 10이 int 형이다.
print(a, type(a))

a = 4.5
print(a, type(a))

# 파이썬은 문자 타입이 존재하지 않는다. 'A'나 "A"나 같은 타입이다.
a = 'A'
print(a, type(a))

a = "A"
print(a, type(a))

# 복소수 타입 존재
a = 3 - 4j
print(a, type(a))