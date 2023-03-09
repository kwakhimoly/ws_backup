import pandas as pd
import numpy as np

s = pd.Series([1,2,3,np.nan,5,6,np.nan])
print(s)
print(s.isnull())   #   각 요소가 NaN이면 True, NaN이 아니면 False

# 데이터 건수가 100만건인데 딱 하나만 NaN이면..
print(s.isnull().sum()) #   결과가 True인 것의 건수를 센다.

"""
데이터 프레임
    각 필드 별로 예를 들어 하나의 필드라도 NaN이 있으면 그 행을 완전 삭제할 수도 있다.
    너무 비율이 높을 경우(NaN의 비율)에는 삭제 불가. -> 이런 경우는 대체를 한다.(대체 값: 평균값(비범주형자료), 중간값(비범주형자료), 최대빈도수(범주형자료))
"""

data = pd.read_csv("./data2/data.csv")
print(data.info())  #   데이터 개수 보고 누락치 있는지 확인 가능
print(data.head())
print(data.columns)
# print("평균: ", data["weight"].mean()) -> NaN이 포함 되어 있어서 버전따라 계산이 될 수도, 안 될 수도 있음

"""
 필드에 NaN 값 확인 방법
    dropna=False : NaN 값 포함해서 카운트 => 카테고리 타입 체크에 적합
"""
print(data['height'].value_counts(dropna=False))
print(data['height'].isnull())  #   NaN일 때 True 반환
print(data['height'].notnull())  #   NaN 아닐 때 True 반환

# NaN 값을 카운트
print(data['height'].isnull().sum())
print(data['weight'].isnull().sum())

"""
처리방법 1. 삭제
    axis: 삭제 방향(1: 열을 삭제해라)
    NaN값을 포함한 열이 있으면 삭제시켜라
    tresh : 삭제할 때 어떤 조건을 삭제할지(삭제 배제 조건)
        ex) thresh=28: NaN이 아닌 데이터가 28건쯤 있는 열은 빼고, 그것도 안 되는 열은 삭제 시켜라.
                    weight는 28건 이상이 데이터가 존재하기 때문에 남고, height는 28건이 충족되지 않기 때문에 열이 삭제 됨.
    삭제한 반환 값을 다른 변수에 다시 담음(원본 삭제는 위험하기 때문)
"""        
data2 = data.dropna(axis=1, thresh=28)
print(data2)

# axis = 0 : 행을 삭제해라
# NaN 값이 있는 행은 무조건 삭제
data3 = data.dropna(axis=0)
print(data3.shape)
print(data3['height'].isnull().sum())
print(data3['weight'].isnull().sum())

# 두 행 다 NaN인 경우만 삭제
data4 = data.dropna(axis=0, thresh=2)
print(data4.shape)
print(data4['height'].isnull().sum())
print(data4['weight'].isnull().sum())

data2 = data.dropna(subset=['height'], how='any', axis=0)
print(data2.shape)
data2 = data.dropna(subset=['weight'], how='any', axis=0)
print(data2.shape)
data2 = data.dropna(subset=['height', 'weight'], how='any', axis=0)
print(data2.shape)