"""
1.iris 데이터 셋에 몇 개의 필드가 있고 각 필드의 타입이 무엇인지 확인
2.맨 앞의 데이터를 7개만 출력
3.iris 데이터셋의 통계량을 확인(평균, 표준편차, 중간값, 사분위수..)
4.variety이 setosa인 데이터의 통계량을 출력
5.각각 variety가 setosa, virginica versicolor의 sepal.length 값의 평균값 출력
6.꽃의 종류가 setosa이면서 sepal.length 길이가 5cm이상인 것 개수 출력
"""

import pandas as pd

df = pd.read_csv("./data/iris.csv")

# 1번
print(df.info())
print("-------------------\n2번")

# 2번
print(df.head(7))
print("-------------------\n3번")

# 3번
print(df.describe())
print("-------------------\n4번")


# 4번
setosa = df[df.variety=="Setosa"]
print(setosa.describe())
print("-------------------\n5번")

# 5번
import numpy as np

# value_count : 종류 정보
print(df['variety'].value_counts())
print()

"""
데이터 분석 시: 범주형, 비범주형
    
    범주형
        연속적이지 않음.
        종류, 선호도(1.5를 선택하지 않음)
        범주형, 카테고리타입, 팩터타입
        평균이 중요하지 않고 발생 빈도수를 중시함 -> value_counts 함수 통해 발생빈도수를 구한다.
    비범주형
        연속된 값.
        평균이 중요함
        집값, 몸무게, 키 등..
        연비 -> 평균이 중요, 비범주형 / 연비 등급 -> 범주형(카테고리 타입)

    카테고리 타입과 비카테고리 타입은 분석부터 차트까지 처리하는 방식이 다 다름
"""

sAndv = df[np.logical_or(df.variety=="Setosa", df.variety=="Virginica")]
print(sAndv.describe())
print("-------------------\n6번")

"""
단 필드명 안에 . 이 있어서 충돌날 때 새로운 필드를 추가할 때는 df1.kor 이런식으로 기술할 수 없다.
"""

# 6번
sAndl = df[np.logical_and(df.variety=="Setosa", df["sepal.length"]>=5)]
print(sAndl.shape)