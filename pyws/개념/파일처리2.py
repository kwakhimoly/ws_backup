with open("test2.txt", "w", encoding="utf-8") as f:
    line = input("아무거나: ")
    while line != "":
        print(line, file=f) #   출력이 파일로 간다.
        line = input("아무거나: ")


with open("test2.txt", "r", encoding="utf-8") as fin:
    lines = fin.readlines()
    print(lines)