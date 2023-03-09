import math

# 자바의 import는 라이브러리는 이미 메모리에 있고, 이름이 너무 길어서 단축 이름 쓰고 실제 이름을 찾아가라는 식
# 파이썬의 import는 라이브러리를 불러와라(메모리에 가져와라)
print(math.gcd(4, 24))  #   최대 공약수
print(dir(math))    #   라이브러리 내의 함수를 모두 알려줌

print(math.ceil(4.3))   #   올림수
print(math.ceil(4.9))   #   올림수

import os
print(os.curdir)    #   현재 디렉토리(.)
print(os.getcwd())    #   실제 현재 경로 알아오기