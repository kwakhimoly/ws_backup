import pandas as pd

df = pd.read_csv("./data/auto-mpg.csv")
print(df)

"""
    실제 데이터가 만 건만 넘어가도 눈으로 확인이 불가능하다
    전체 구조 확인용 함수들이 있다.
"""

# 앞쪽으로부터 데이터 5건만 출력
print(df.head())
print(df.head(10))  #   10줄 출력

print(df.tail())    #   뒤쪽에서 5줄
print(df.tail(10))  #   뒤쪽에서 10줄

# 각 필드들에 대한 간략한 설명
# 각 필드에 대한 데이터 건수 타입들
print(df.info())

# describe : 기초 통계값
print(df.describe())
print("----------")


# 행과 열의 개수
# shape : 함수가 아니라 튜플 변수라 () 없이 사용 -> 별다른 기준 없대..
print(df.shape)
print("-------------------")


# 실린더 개수가 4개인 조건을 줬을 경우
# 실린더 개수가 4인 데이터에 대해 True, 아니면 False를 데이터 개수만큼 반환
print( df.cylinders == 4)

print( df[df.cylinders == 4]) #실린더 4개인 데이터만 추출된다. 

print("---")

df2 = df[df.cylinders == 4]
print( df2.shape )

#연비가 평균이 넘는 데이터만 추출하고자 한다 
#연비 평균 mpg 필드의 평균값 구하기

mpg_mean = df["mpg"].mean()
print("연비 평균: ", mpg_mean)

print("----")

df3 = df[df.mpg>=mpg_mean]
print(df3.head())

print("-------")

# 연비도 평균이 넘고, 마력도 평균이 넘고?
hp_mean = df["horsepower"].mean()
# and : 벡터 연산을 수행하지 않는다. 파이썬 기능. 벡터 연산은 scalar에서만 수행

import numpy as np
# numpy에 있는 logical 시리즈 통해서 논리 연산자 사용(and, or ....)

df3 = df[np.logical_and(df.mpg>=mpg_mean,df.horsepower>=hp_mean)]
print(df3)