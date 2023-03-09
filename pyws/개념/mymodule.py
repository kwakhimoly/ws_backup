def sigma(limit = 10):
    s=0
    # limit+1 을 하는 이유는 range가 마지막 숫자는 빼놓고 발생시킨다.
    for i in range(1, limit+1):
        s = s+i
    return s

def circle(radius=5):
    return radius*radius*3.14

def toUpper(s):
    # chr(코드): 문자
    # ord(문자): 코드
    temp=""
    for c in s:
        if(ord(c)>=ord('a') and ord(c)<=ord('z')):  #   소문자일 때만 대문자로 바꾼다
            temp = temp+chr(ord(c)-32)
            # 코드가 소문자 a는 65, 대문자 A는 97 -> 둘 사이의 차가 32
        else:   #   나머지는 그냥 temp에 더함
            temp = temp+c
    return temp


if __name__=="__main__":
    # mymodule이란 파일은 main으로 사용될 수도 있고, 다른 모듈에서 import되어 사용될 수도 있음
    print(__name__) #   내장변수(__name__), 내가 main으로 쓰일 때는 __main__이라는 이름이 출력됨.
                    #                       모듈로 쓰일 때는 파일명이 온다.
    print(sigma(100))
    print(circle(6))
    print(toUpper("I like starwars"))