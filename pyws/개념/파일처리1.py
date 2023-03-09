# 파일은 크게 두가지 유형이 있다. 
# 텍스트 파일과 이진파일이 있다
# 텍스트파일은 일반적인 메모장류에서 작성한 파일들, 예를들어 txt, .ini, 소스파일들(.java, .py) 등이 있고 
# 이 파일들은 컴퓨터 메모리에서 외부장치로 저장될때  엔터키를 가공해서 저장한다 
# os 에 따라 저장방식이 다르다.  \r\n 또는 \n으로 가공되서 줄바꿈으로 인식한다.
# 이진 파일은 컴퓨터 메모리 그대로 외부장치로 저장된다.
# 예) 이미지, 동영상, 실행파일 등등
# 이진파일 읽고 쓰기와 텍스트 파일 읽고 쓰기는 다르다.

"""
    파일 읽고 쓰기 절차
    파일을 열고     -      open 함수 통해서 열고
    읽고 쓰기 다 하고
    파일 닫고       -      close
"""


# 1. 텍스트 파일 읽기
# open("파일명", "모드", 인코딩)    
#       text.txt 파일을 읽기 모드로 연다.
#       한글의 경우 반드시 인코딩을 해야 한다.
# f는 읽기 위해 연 파일에 대한 참조를 가지고 있다.

f = open("text.txt", "r", encoding="utf-8")
lines = f.readlines()   #   파일을 한 번에 다 읽는다.

for line in lines:
    line = line[:(len(line)-1)] #   맨 뒤의 엔터키 지운다.
    print(line)

f.close()

# with 문법 -   자원을 사용하고 자동 반납해주는 구문

with open("text.txt", "r", encoding="utf-8") as f:
    lines = f.readlines()
    for line in lines:
        line = line[:(len(line)-1)]
        print(line)
# close 빼먹어도 알아서 잘 해준다. 

# 한줄씩 읽어서 처리하기
with open("text.txt", "r", encoding="utf-8") as fin:
    line = fin.readline()
    while line!="":
        print(line[:len(line)-1])
        line = fin.readline()