import random

class Lotto:
    lottoLi = list()
    
    while True:
        num = random.randint(1,10)
        lottoLi.append(num)
        
        for j in lottoLi:
            temp = lottoLi.count(num)
            
            if temp>1:
                print("{}: {}".format(temp, num))
                lottoLi.remove(num)

        if len(lottoLi)==6:
            break

    print(lottoLi)

class MyLotto:
    def __init__(self):
        self.lottoList = list()
    def createLotto(self):
        while True:
            num = random.randint(1,10)
            if num not in self.lottoList:
                self.lottoList.append(num)
            if len(self.lottoList)==6:
                break
    def display(self):
        for num in self.lottoList:
            print(num, end=" | ")

m1=MyLotto()
m1.createLotto()
m1.display()