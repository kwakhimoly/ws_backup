# ord() : 문자의 코드 값을 반환하는 함수
print(ord("A"))

# 키보드로 문장을 입력 받아서 문장 안에 쓰인 문자의 개수를 세서 출력한다.
# sentence = input("입력: ")
# k = []
# for i in range(0,len(sentence),1):
#     k.append(sentence[i:i+1])

s = input("문장 : ")
count = list()
for i in range(0,26):
    count.append(0)

for i in range(0, len(s)):
    if ord(s[i])>=ord('A') and ord(s[i])<=ord('Z'):
        count[ord(s[i])-65]+=1
    if ord(s[i])>=ord('a') and ord(s[i])<=ord('z'):
        count[ord(s[i])-97]+=1

for i in range(0,26):
    print(chr(i+65), "==>", count[i])