import pandas as pd

data = {
    "name":["홍길동", "김길동", "박길동", "이길동"],
    "kor": [90,80,100,70],
    "eng": [70,90,80,100],
    "mat": [80,100,90,70]
}

df = pd.DataFrame(data)
print(df)

# 'i'loc: 'i'ndex 통해 접근
print(df.iloc[0,0])
# loc: 필드명으로 접근
print(df.loc[0,"name"])

# : 써주면 한 행이 출력 됨.
# 0번째 행
# 행의 이름이 0,1,2,3
print(df.iloc[0, :])
print(df.loc[0,:]) 

# 열 출력
print(df.iloc[:,0])
print(df.loc[:,'name'])

# 홍길동, 박길동 데이터만 추출
# 특별히 추출하고자 하는 행이나 열의 인덱스를 리스트로 만들어 전달한다.
print(df.iloc[[0,2], :])

# 열을 추출해보자(name 필드, eng 필드, mat 필드)
print(df.loc[:,['name','eng','mat']])

# 다른 개체로 복사
df2 = df.loc[0:4, ['name', 'mat', 'kor']]
print(df2)

print("----------")

"""
     데이터 추가하기 : 추가할 때는 dict 타입을 이용해 추가
     list 타입은 추가를 하면 자기가 바뀜
     dataframe 타입은 새로 항목을 추가한 객체를 반환하는 구조
     반환값을 받아야 새로 추가가 된다.
"""
df = df.append({"name":"정길동", "kor":45, "eng":30, "mat":100}, ignore_index=True)
# ignore_index=True: True만 쓸 수 있음. False는 못 씀.
#                   데이터가 추가가 되면 인덱스를 새로 부여해야 하는데, 기존 인덱스를 무시하라는 의미

"""
    조만간 append 없어짐 - concat으로 대체됨
    concat : 원래 목적 -> 병합, 데이터프레임을 열 또는 행으로 합칠 능력
    concat([df1, df2, df3], 병합조건)
    axis - 축,  1차원일 때는 축이 0 하나
                2차원일 때는 축이 0, 1(행, 열)
                3차원일 때는 축이 0, 1, 2(행, 열)
"""
df = df.append({"name":"최길동", "kor":95, "eng":90, "mat":100}, ignore_index=True)
df = df.append({"name":"강길동", "kor":75, "eng":42, "mat":60}, ignore_index=True)
df = df.append({"name":"조길동", "kor":55, "eng":67, "mat":57}, ignore_index=True)
# => 옛날 방식

# axis = 0, 행을 말함
df = pd.concat([df, pd.DataFrame({"name":["윤길동"], "kor":[85], "eng":[85], "mat":[65]})], axis=0, ignore_index=True)

print(df)

"""
csv 파일: 엑셀을 읽을 수 있고 데이터들을 보통은 ','으로 구분해서 저장하는 방식
"""

# 컬럼명 확인하기
print(df.columns)

# 새로 컬럼명 부여하기
df.columns = ["이름", "국어", "영어", "수학"]
print(df)

# 새로운 컬럼 추가하기
df["total"] = df["국어"] + df["영어"] + df["수학"]
df["avg"] = df["total"]/3
print(df)        