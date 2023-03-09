a = int(input("a= "))

# and 연산은 단축평가, & 연산은 단축평가를 하지 않고 모든 연산에 대한 평가를 진행한다.
# True and True = True
# False and True = False
#               and 연산자에 첫 값이 False 인 경우 그 뒤의 값은 평가 자체를 하지 않음 -> 단축평가
# False and False = False
# & : 혹시 모르니까, 뒤의 수식까지도 평가를 함

# True or ___ : 이미 True가 왔으니 뒤의 ___은 평가할 필요가 없음
# True | ___ : 혹시 모르니 ___까지도 평가를 함

if a & 10/a:    #   a는 0보다 커야 하고, 10/a의 결과도 0보다 커야 한다.
    print(a)
else:
    print("실패: ", a)

# a & 10/a : float은 & 연산자 사용 불가해서 예외처리 됨(캡쳐1 참고)
# a and 10/a : 10/a를 처리하지 않기 때문에 a>0 조건을 만족하지 못하는 경우 그냥 바로 끝나고 else 출력