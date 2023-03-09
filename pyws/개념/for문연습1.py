# for(i=0; i<=10; i++){} 없어짐

# iterator 또는 Enumeration : 현재 객체 지향 언어에 다 있는 개념
# 클래스를 만드는데, 클래스가 컬렉션류일 때, 내부에 배열을 갖거나 linkedlist 등의 무엇인가를 담아두어야 하는 클래스를 설계할 때,
# 외부의 클래스 사용자가 클래스 내부의 실제 데이터 배치 상태를 몰라도 언제나 동일한 형태로 전체 데이터를 순회할 수 있도록 하는 인터페이스를 말한다.
# 배열의 경우에는 a[0], a[1], ... 내부에 링크드 리스트의 경우 a, a.next, a.next.next, ,,, 이런식으로 실제 데이터에 대한 접근 방법은 다르다.
# 그래서 고안해낸 것이 iterator나 enumeration이다
# iterator은 컬렉션 클래스를 만드는 쪽에서 제공한다. 데이터를 맨 처음것부터 차례 차례 다음 데이터로 이동하는 것을 보장한다.

# for 변수명 in iterable 객체
for i in [1,2,3,4,5,6,7,8,9,10]:
    print(i)
print("----")

# range(시작값,종료,증감치) - iterable
print(list(range(1,11,1)))
print("----")

for i in range(1,11,1):
    print(i, end=" ") # end="(기본값 = "\n"(엔터키))"
print("\n----")

# 짝수 출력
for i in range(2,101,2):
    print(i, end=" ")
print("\n----")

# 홀수 출력
for i in range(1,101,2):
    print(i,end=" ")
print("\n----")

# 100,90,80...
for i in range(100,0,-10):
    print(i,end=" ")
print("\n----")