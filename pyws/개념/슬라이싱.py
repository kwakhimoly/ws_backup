s = "abcde fghijklmn"
# s는 문자열이 아니고 배열이 아닌데 배열처럼 인덱싱이 가능하다
print(s[0]) # 인덱싱, 자바의 s.chartAt(0)와 같음
print(s[1])
print(s[3])
print(s[7])
print(s[9])

# 슬라이싱 [시작:종료:증감치]
print(s[::]) # 전체 다 출력
print(s[0:5]) # abcde 까지만 출력된다. 맨 마지막은 빼고 0,1,2,3,4 
print(s[0:8:2]) # 0,2,4,6 까지만 출력. 마지막 8번째 문자열은 빠진다.
print(s[::-1]) # 뒤에서부터 역순으로 출력된다.
# 시작:종료:증감치에서 시작하고 종료는 음수를 사용할 수 없다.
# print(s[7:-1:-1]) # 사용불가
print(s[7::-1])

# s[0]='h' # 인덱싱을 통해서 값을 바꿀 수 있는가? - 문자열은 안 됨
s = "h"+s[1:]
print(s)

s = "I like star. red star. blue star."
s = s.replace("star", "moon") # 문자열 바꿔치기 (replace는 바꿔서 return으로 내보내기 때문에 변수에 따로 담아줘야 함.)
print(s)

