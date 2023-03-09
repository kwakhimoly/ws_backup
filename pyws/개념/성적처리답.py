scoreList = [] # 전역개체

# 이 함수는 과목명을 갖고 와야 한다. 제대로 된 값을 하나 읽어서 반환한다.

def isNumeric(s):   #   숫자로만 이루어진 문자열이면 True
    for i in range(0,len(s)):
        if ord(s[i])<ord('0') or ord(s[i])>ord('9'):
            return False
    return True     #   아니면 False 반환

def getNumber(subject):
    temp = input(subject+":")
    while not isNumeric(temp):
        print("숫자를 입력하세요")
        temp = input(subject+":")
        # 숫자일 때만 while문 종료
    return int(temp)    

def getScore(subject):
    temp = getNumber(subject)
    while temp<0 or temp>100:
        print("0~100 사이의 값만 입력하세요")
        temp = getNumber(subject)
    return temp

def append():
    score = {} #자바도 dto 안 만들고 map을 사용한다. python의 dict 타입이 자바의 hashmap과 유사

    score["name"] = input("이름: ")
    score["kor"] = getScore("국어")
    score["eng"] = getScore("영어")
    score["mat"] = getScore("수학")
    scoreList.append(score)

def output():
    for score in scoreList:
        print("{} {} {} {}".format(score["name"], score["kor"], score["eng"], score["mat"]))
        
def cal():
    for score in scoreList:
        sum = score["kor"]+score["eng"]+score["mat"]
        avg = sum/3
        name = score["name"]
        print(f"{name}의 총점: {sum}, 평균: {avg}")


def start():

    while True:
        print("0.종료")
        print("1.추가")
        print("2.출력")
        print("3.평균,합")
        sel = input("선택: ")
        if sel=="1": 
            append()
        elif sel=="2":
            output()
        elif sel=="3":
            cal()
        elif sel=="0":
            return

 
# 총점, 평균 계산
# 데이터 입력시 에러 체크하게
# 점수 입력 받아서 숫자로 전환가능한지 확인하고 숫자로 바꾸고, 숫자가 아니면 에러 발생
# 점수가 숫자 맞는데 0~100 사이어야 함. 100이 넘어가면 에러체크 하기.

start()