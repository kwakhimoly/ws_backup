import mymodule

print("모듈사용하기")

print(mymodule.sigma(99))
print(mymodule.circle(34))
print(mymodule.toUpper("may the 4th"))

# import 구문은 모듈명.함수명() 형태로 사용해야 한다. from을 사용하면 마치 내가 갖고 있는 함수처럼 가지고 올 수도 있다.
from mymodule import sigma, circle, toUpper
# from (모듈명) import (함수명): 이렇게 추가한 함수들은 앞의 모듈명을 생략하고 사용할 수 있다.

print(sigma(32))
print(circle(3))
print(toUpper("be with you"))