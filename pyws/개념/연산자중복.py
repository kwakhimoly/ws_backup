# 연산자 중복: 이미 존재하는 연산자에 새로운 기능을 부여할 때 유용하다.
# s1 = "Hello"
# s2 = "Python"
# s3 = s1 + s2  : 여기서 + 연산자는 문자열을 연결하기 위한 용도
# 본래 의미의 + 연사는 수치형 자료를 연산하기 위해 사용.
# 본래 의미의 +를 다시 만들어서 새로운 기능을 부여하는 걸 연산자 중복이라 함. (자바엔 없는 기능. c++,c#,python 에는 있음)

# 행렬 클랫
class Matrix:
    def __init__(self, mat1=None):
        if mat1 == None:
            self.mat1 = [
                        [1,2,3],[4,5,6],[7,8,9]
                        ]
        else:
            self.mat1 = mat1
    def output(self):
        for i in range(0, len(self.mat1)):
            for j in range(0, len(self.mat1[i])):
                print("{0} ".format(self.mat1[i][j]), end=" ")
            print()
    
    # m3 = m1 + m2 를 할 경우에 __add__를 호출한다.
    def __add__(self, other):
        temp = list(list()) #   2차원 형태
        for i in range(0, len(self.mat1)):
            item = list()
            for j in range(0, len(self.mat1[i])):
                item.append(self.mat1[i][j]+other.mat1[i][j])
            temp.append(item)
        return Matrix(temp) #   객체 만들어서 반환하기
    


m1 = Matrix()
m2 = Matrix([[3,4,5],[6,7,8],[9,10,11]])

m1.output()
print("---")
m2.output()
print("---")
m3 = m1.__add__(m2) #   m3 = m1 + m2
m3.output()
print("---")
m4 = m3 + m2
m4.output()