#dict 안에 list 담기

score = {
     "name":["홍길동", "김길동", "이길동", "박길동"],
     "kor":[90,90,78,98],
     "eng":[79,79,90,78],
     "mat":[98,78,68,78]
 }

print(score["name"][0])
print(score["name"][1])
print(score["name"][2])
print(score["name"][3])

print(score["kor"][0])

#총점 필드를 score["필드명"] -> 노가다 방법
score["total"]=list() #score["total"] = []
score["total"].append(score["kor"][0]+score["eng"][0]+score["mat"][0])
score["total"].append(score["kor"][1]+score["eng"][1]+score["mat"][1])
score["total"].append(score["kor"][2]+score["eng"][2]+score["mat"][2])
score["total"].append(score["kor"][3]+score["eng"][3]+score["mat"][3])

print(score)