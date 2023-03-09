# static 메소드
class TestClass:
    # 변수 앞에 __ 를 붙이면 private 변수이다.
    __intCount = 0

    # TestClass 객체가 몇개 만들었는지 확인
    def __init__(self): #   생성자에서 카운트를 한다.
        TestClass.__intCount += 1 
        # self가 아니고 클래스 멤버이므로 클래스를 이용해 접근한다.
        # 객체가 생성될때마다 __intCount 변수값이 증가한다.
    # __intCount 값을 출력하는 함수를 만든다.
    def staticPrintCount(): #   이 메소드는 static 메소드이다.
                            #   매개 변수에 self를 쓸 수 없다.
                            #   객체에 속한 함수가 아니라서 객체를 뜻하는 self는 쓰지 않는다.
        print("현재 카운트: {}".format(TestClass.__intCount))

    # 별도로 static 메소드로 만들어주는 작업이 필요하다.
    # staticmethod 라는 함수를 통해서 static 메소드를 만들었음
    SPrintCount = staticmethod(staticPrintCount)

    # 자바의 annotation처럼 생겼는데 파이썬에서는 데코레이터(decorator) 라고 부른다.
    @staticmethod
    def staticPrintCount2():
        print("현재 카운트: {}".format(TestClass.__intCount))
    
    # 클래스 메소드 : 매개변수로 클래스를 전달한다.
    @classmethod
    def classPrintCount(cls):
        print("현재카운트 {}".format(cls.__intCount))
        


t1 = TestClass()
TestClass.staticPrintCount()
TestClass.SPrintCount()

t2 = TestClass()
TestClass.staticPrintCount2()
TestClass.SPrintCount()
#   print(t1.__intCount)    #   private 변수라 볼 수 없어서 예외 발생