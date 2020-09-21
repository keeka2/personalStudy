import time

#시작시간
start_time = time.time()

#싱글
def count(name):
    a=0
    for i in range(5000000):
        a+=1
        print(a)

num_list = ['p1', 'p2', 'p3', 'p4']
for num in num_list:
    count(num)

print("--- %s seconds ---" % (time.time() - start_time))
#73.79063844680786 seconds
