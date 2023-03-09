class User:
    def __init__(self, name="", email="", phone=""):
        self.name = name
        self.email = email
        self.phone = phone
    
    # 매개변수들을 tuple 타입으로 전달 받는다.
    # u1 = User(("홍길동", "hong@email.com", "010-0001-0001"))
    @classmethod
    def fromTuple(cls, tup):
        return cls(tup[0], tup[1], tup[2])
    
    def output(self):
        print(self.name, self.email, self.phone)

    @classmethod
    def fromDict(cls, data):
        return(data["name"], data["email"], data["phone"])
    
u1 = User("홍길동", "hong@email.com", "010-0001-0001")
u2 = User.fromTuple(("김길동", "kim@email.com", "010-0002-0002"))
u3 = User.fromDict({"name":"박길동", "email":"park@email.com", "phone":"010-0003-0003"})

u1.output()
u2.output()
u3.output()