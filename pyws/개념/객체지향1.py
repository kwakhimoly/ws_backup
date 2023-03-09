# 클래스 선언 - 파이썬은 객체를 만들지 않아도 클래스 멤버
class Person:
    name = "홍길동" #   클래스 멤버, 메모리가 미리 확보됨. 기보 public
    age = 23

    def output(self):    #   첫번째 매개변수로 self를 두고 객체 변수나 함수를 사용할 때
                        #   반드시 self로 호출해야 한다.
        print("이름: ", self.name)
        print("나이: ", self.age)
    # def output(this):    변수명은 상관없음
    #     print("이름: ", this.name)
    #     print("나이: ", this.age)

print(Person.name)
print(Person.age)

p1 = Person()   #   인스턴스(객체) 만들기
p1.output()