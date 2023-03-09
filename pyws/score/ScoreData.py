# 파이썬은 생성자를 통해서 변수를 선언
class ScoreData:
    def __init__(self, name="", kor=0, eng=0, mat=0):
        self.name=name
        self.kor=kor
        self.eng=eng
        self.mat=mat
        self.process()

    # 총점 평균 구하기
    def process(self):
        self.total = self.kor+self.eng+self.mat
        self.avg = self.total/3
        if self.avg>=90:
            self.grade = "A"
        elif self.avg>=80:
            self.grade = "B"
        elif self.avg>=70:
            self.grade = "C"
        elif self.avg>=60:
            self.grade = "D"
        else:
            self.grade = "F"

    def display(self):
        print("{}: {}, {}, {}, {}, {:.3f}, {}".format(self.name, self.kor, self.eng, self.mat, self.total, self.avg, self.grade))

