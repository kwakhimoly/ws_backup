from ScoreData import ScoreData
import pickle

class ScoreManager:
    dataList = list()
    # 생성자에 기본값 넣기
    def __init__(self):
        self.load()
        # self.dataList.append(ScoreData("AB", 100,100,100))
        # self.dataList.append(ScoreData("BC", 30,60,30))
        # self.dataList.append(ScoreData("CD", 80,80,80))
        # self.dataList.append(ScoreData("DE", 60,60,60))
        # self.dataList.append(ScoreData("EF", 70,70,70))

    def append(self):
        s = ScoreData()
        s.name = input("이름: ")
        s.kor = int(input("국어: "))
        s.eng = int(input("영어: "))
        s.mat = int(input("수학: "))
        s.process()
        self.dataList.append(s)
    
    def output(self):
        for item in self.dataList:
            item.display()
    

    def search(self):
        name = input("이름: ")
        # filter(람다식, 리스트)
        # filter 함수에 전달할 람다식은 반환값이 True 또는 False인 것
        # filter에 전달되는 람다함수는 데이터 요소마다 호출된다. 
        # 이 함수는 데이터 요소를 파라미터로 하고 반환값은 반드시 True 또는 False여야 한다.
        find = False
        for i in filter(lambda x: x.name==name, self.dataList):
            i.display()
            find = True

        if find==False:
            print("없습니다.")

    def modify(self):
        name = input("수정할 이름: ")
        modifyList = list(filter(lambda a: a.name==name, self.dataList))
        
        if len(modifyList)==0:
            print("수정할 데이터가 없습니다.")
            return
        
        i=1
        for item in modifyList:
            print("{}번째 : ".format(i), end="")
            item.display()
            i+=1
        pos = int(input("수정할 항목의 번호를 선택하세요:"))

        if pos<0 or pos>len(modifyList):
            print("잘못 선택하셨습니다.")
            return
        
        modifyList[pos-1].name=input("이름: ")
        modifyList[pos-1].kor=int(input("국어: "))
        modifyList[pos-1].eng=int(input("영어: "))
        modifyList[pos-1].mat=int(input("수학: "))
        modifyList[pos-1].process()

        print("수정되었습니다.")
    
    def deleteData(self):
        name = input("삭제할 이름: ")
        deleteList = list(filter(lambda a: a.name==name, self.dataList))
        
        if len(deleteList)==0:
            print("삭제할 데이터가 없습니다.")
            return
        
        i=1
        for item in deleteList:
            print("{}번째 : ".format(i), end="")
            item.display()
            i+=1
        pos = int(input("삭제할 항목의 번호를 선택하세요:"))

        if pos<0 or pos>len(deleteList):
            print("잘못 선택하셨습니다.")
            return
        
        # 삭제하기
        deleteItem = deleteList[pos-1]  #   삭제 대상이 되는 참조를 가져온다.
        self.dataList.remove(deleteItem)    #   원래 list에서 삭제한다.
        print("삭제되었습니다.")
    
    def sortingData(self):
        sortedList = sorted(self.dataList, key=lambda item: item.grade)
        # lambda의 x: ScoreData 참조값 -> list로 묶어서 sortedList 에 넣기
        for i in sortedList:
            i.display()
            # display() 같은 함수 사용하려면 ScoreData 형식이어야 함 -> sortedList의 i번째 항목을 꺼내오면 ScoreData

    def save(self):
        f = open("score.txt", "w", encoding="utf-8")
        for item in self.dataList:
            print("{} {} {} {}".format(item.name, item.kor, item.eng, item.mat), file=f)
        f.close()
    
    def load(self):
        self.dataList = list()  #   불러오기 할 때 이 전 데이터를 삭제 해야 해서 새로 객체를 생성한다.
        f = open("score.txt", "r", encoding="utf-8")
        line = f.readline()
        # 한 줄씩 읽는다. 그래서 문장을 공백기준으로 토큰으로 분리해야 한다.
        while line != "":
            # 토큰 분리
            tokens = line.split(" ")
            data = ScoreData()
            data.name = tokens[0]
            data.kor = int(tokens[1])
            data.eng = int(tokens[2])
            data.mat = int(tokens[3])
            data.process()
            self.dataList.append(data)
            line = f.readline() #   다음줄을 읽는다.

    def p_save(self):
        file = open("score.bin", "wb")
        pickle.dump(self.dataList, file=file)
        file.close()
    
    def p_load(self):
        file = open("score.bin", "rb")
        self.dataList = pickle.load(file=file)
        file.close()

    def menuDisplay(self):
        print("1.추가")
        print("2.출력")
        print("3.검색") #   filter 이용하기
        print("4.수정") #   filter
        print("5.삭제") #   filter
        print("6.정렬") #   sorted
        print("7.저장")
        print("8.불러오기")
        print("9.pickle로 저장")
        print("10.pickle로 불러오기")
        print("0.종료")

    def start(self):
        while True:
            self.menuDisplay()
            sel = input("선택 : ")
            if sel == "1":
                self.append()
            elif sel == "2":
                self.output()
            elif sel == "3":
                self.search()
            elif sel == "4":
                self.modify()
            elif sel == "5":
                self.deleteData()
            elif sel == "6":
                self.sortingData()
            elif sel == "7":
                self.save()
            elif sel == "8":
                self.load()
            elif sel == "9":
                self.p_save()
            elif sel == "10":
                self.p_load()
            elif sel =="0":
                print("프로그램을 종료합니다.")
                return
    
if __name__ =="__main__":
    sm = ScoreManager()
    sm.start()