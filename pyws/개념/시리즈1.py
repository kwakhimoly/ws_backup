import pandas as pd

"""
    가끔 라이브러리를 import 할 때 라이브러리에 새로운 이름을 부여할 수 있다.
    as 구문 다음에 ailasing을 붙인다.
"""
print("**시작**")
data = [10,20,30,40,50] #   list 타입
# pandas의 series 타입으로 전환하자.
series = pd.Series(data)

print(type(data))
print(type(series))

print(data)
print(series)
"""
    series
    - 인덱스가 있음
    - 특별히 지정 안하면 0,1,2,3...
"""
# print(data>30) : 에러 발생(파이썬 타입으로는 이렇게 작성 불가.)
print([a for a in data if a>30])    #   파이썬식
"""
    파이썬은 스칼라(변수 하나) 단위로 연산을 수행.

    수학 라이브러리들은 벡터 단위로 연산을 수행
        벡터 : 1차원, 2차원 등의 배열 형태
"""
"""
    series[] : 시리즈에서 원하는 정보만 추출 가능
    numpy도 가능하다
"""
print(series[series>30])  #   pandas series식
print(series>30)    #   결과를 실행해서 조건에 맞으면 True 또는 False

# 스칼라연산
a = [1,2,3,4,5]
b = [6,7,8,9,10]
c = a + b   #   a라는 리스트와 b라는 리스트를 합쳐라
print(c)    #   [1,2,3,4,5,6,7,8,9,10]

# 시리즈연산
sa = pd.Series(a)
sb = pd.Series(b)
sc = sa+sb  #   벡터 연산 : 1차원 배열(수학에서의 벡터)
print(sc)
"""
    sc 결과:
    0   7
    1   9
    2   11
    3   13
    4   15
"""

# 인덱싱, 슬라이싱 지원 - 파이썬 타입과 동일
print(sc[0])
print(sc[2])
print(sc[0:3])

# 차이나는 부분
print(sc[[2,4,3]])  #   2,4,3번 데이터 추출

# 조건식 직접 물어보면 벡터 전체에 대해서 결과를 내준다
print(sc>10)    #   결과가 True, False 벡터로 출력

print(sc[[True, True, False, False, True]]) #   True인 것만 출력
print(sc[sc>10])

# dict 타입을 시리즈로 만들면, 앞의 키 값들이 인덱스가 된다.
data = {"one":1, "two":2, "three":3, "four":4, "five":5}
s1 = pd.Series(data)
print(s1)
print(s1["one":"three"])
print(s1[0:3])

print(s1[["three", "two", "four"]])
print(s1[[2,0,1]])

"""
# 특정집단에 대한 성격을 알고 싶을 때 수학적으로 평균
# 최대 빈도수, 최소 빈도수, 최대값, 최소값, 중간값(평균은 왜곡될 가능성이 있다. 그래서 중간에 위치한 값을 통계학에서 많이 활용)
# 평균은 집단의 성격을 아주 조금만 보여준다.
# 오차와 기대치의 차이를 설명하기 위한 값이 분산.
# 분산은 오차의 제곱의 합
# 평균: 70  60,80,50,90,70
# 오차의 합은 언제나 0이다
# 수학적으로 부호를 없애고 싶으면 절대값을 구하거나 제곱을 구한다
# 분산은 오차의 제곱의 합으로 하자 : 수학자
# 편차 분산의 제곱근 : 분산에 루트 씌운거
"""

print("합계: ", s1.sum())
print("평균: ", s1.mean())
print("표준편차: ", s1.std())
print("최대값: ", s1.max())
print("최소값: ", s1.min())
print("중간값: ", s1.median())

print("**끝**")