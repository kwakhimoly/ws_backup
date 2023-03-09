class MyType:
    # 문자열 전체가 대문자로 구성되어 있는지
    @staticmethod
    def isCapital(s):
        for c in s:
            if(ord(c)<ord('A') or ord(c)>ord('Z')):
                return False
        return True #   for문을 다 수행해도 return이 안 된 경우는 전부 대문자이므로 True를 반환한다.
    
    @staticmethod
    def isNumeric(s):
        for c in s:
            if(ord(c)<ord('0') or ord(c)>ord('9')):
                return False
        return True
# 객체를 안 만들고도 사용 가능
# 주로 데이터가 공유될 필요가 없는데 기능상 묶이는 게 맞을 때
# Math class = 수학 함수 같은 경우
print(MyType.isCapital("TEST"))
print(MyType.isCapital("Test"))
print(MyType.isCapital("tEst"))

print(MyType.isNumeric("123"))
print(MyType.isNumeric("T123"))
