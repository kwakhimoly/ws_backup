class Person:
    # 변수를 이 부분에 선언해도 됨
    # 여기 선언된 변수는 소속이 클래스이지 객체가 아님
    # 객체를 새로 생성할 때 메모리가 잡히지 않는다.
    # static을 안 써도 알아서 static 상황이 됨.
    # => 변수가 한 번만 만들어지고 더 이상 만들어지지 않음
    # 자바는 객체를 생성하지 않으면 객체를 소환하지 않는 이상 메모리가 잡히지 않았음 -> 소환 안해도 쓰려고 static 붙였었음
    name = "홍길동" #   변수만 선언하는 방법 없음. 꼭 값을 줘야 함.
    score = list()  #   list 객체를 만들고
    # 버전 따라 다르게 동작가능. 변수를 생성자에서 선언하는게 좋다.
    # 생성자는 __init__ 로 생성

    def __init__(self, name="", score=list()):
        self.name = name
        self.score = score
        # 파이선의 생성자는 한 개만 만들 수 있음
        # def __init__(self, name, score):
        # 이렇게 생성자를 만들면 매개변수 값을 반드시 주어야 한다.
        # 기본 생성자 없는 상황이 되었음
        # p1 = Person() : 에러 발생(매개변수 값을 안 줘서)
        # p1 = Person("홍길동", [90,90,90]) : 이렇게 작성해야 함.

    def append(self, name="", score=[100,100,100]):
        self.name = name
        self.score = score
    def output(self):
        print(self.name, self.score)
p1 = Person()
p1.append("홍길동", [90,90,90])

p2 = Person()
p2.append("김길동", [80,80,80])

p1.output()
p2.output()

p1.score[0]=1000
p1.output()
p2.output()

# 클래스에 새로운 변ㅅ를 추가할 수 있다.
Person.phone = "010-0001-0001"

print(p1.name, p1.score, p1.phone)

# 객체에도 사용하다 중간에 새로운 변수 선언이 가능하다.
# 가능하긴 하지만 쓰진 말자

p2.address = "서울시"
print(p2.name, p2.score, p2.phone, p2.address)

class Student(Person):  #클래스 상속받기 
    def __init__(self, name="", score=list(), className=""):

        #부모 생성자 호출하기 -- 이런식으로 호출한다 
        Person.__init__(self, name, score) 
        self.className=className 

    def output(self):
        print(self.name, self.score, self.className)

s1 = Student("학생1", [100,100,100], "1반")

# 파이썬도 최상위 클래스가 object이다
# 특별히 상속을 받지 않아도 object를 상속받는다.
print(isinstance(s1, Student))
print(isinstance(s1, Person))
print(isinstance(s1, object))