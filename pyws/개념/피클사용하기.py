# 이 라이브러리는 객체를 저장할 수 있다.
# 객체 읽고 쓰기 - 직렬화
# 파일에 객체를 읽고 쓰게 하는 걸 직렬화라고 함
# 객체를 바이트 배열로 바꿔야 파일에 읽고 쓸 수 잇다.
# 파이썬은 pickle 하나로 다 가능
import pickle

# 파일에 객체 저장하기
col = {"red":"빨강", "orange":"주황", "yellow":"노랑", "green":"초록", "blue":"파랑", "navy":"남색", "purple":"보라"}
file = open("test.bin", "wb")   #   w-write, b-binary : 파일을 이진으로 생성
pickle.dump(col, file=file)
file.close()

# 파일에서 객체 읽기
colors = {}
file = open("test.bin", "rb")   #   r-read, b-binary : 파일을 이진으로 
colors = pickle.load(file=file)
file.close()

print(colors)