scoreList = [] # 전역개체

def append():
    score = {} #자바도 dto 안 만들고 map을 사용한다. python의 dict 타입이 자바의 hashmap과 유사

    score["name"] = input("이름: ")
    score["kor"] = input("국어: ")
    score["eng"] = input("영어: ")
    score["mat"] = input("수학: ")
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

def typeError():
    for score in scoreList:
        if (score["kor"].isnumeric() or score["eng"].isnumeric() or score["mat"].isnumeric())==False:
            scoreList.remove(score)
            print("점수는 정수로 입력해주세요.")
            return
        else:
            score["kor"]=int(score["kor"])
            score["mat"]=int(score["mat"])
            score["eng"]=int(score["eng"])


def scoreError():
    for score in scoreList:
        if (score["kor"] or score["eng"] or score["mat"]) > 100 or (score["kor"] or score["eng"] or score["mat"]) <0:
            print("점수 입력 실패. 다시 시도해주세요.")
            scoreList.remove(score)
            return

def start():
    while True:
        print("0.종료")
        print("1.추가")
        print("2.출력")
        print("3.평균,합")
        sel = input("선택: ")
        if sel=="1": 
            append()
            typeError()
            scoreError()
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