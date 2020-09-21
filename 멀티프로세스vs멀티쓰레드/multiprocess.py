import multiprocessing
import time

#시작시간
start_time = time.time()

#멀티쓰레드 사용 하는 경우 (200만 연산)
#Pool 사용해서 함수 실행을 병렬
def count(name):
    a=0
    for i in range(500000):
        a+=1
        print(a)
    # for i in range(250000):
    #     a+=1
    #     print(a)

num_list = ['p1', 'p2', 'p3', 'p4']
# num_list = ['p1', 'p2', 'p3', 'p4','p5','p6','p7','p8']
if __name__ == '__main__':
    #멀티 쓰레딩 Pool 사용
    pool = multiprocessing.Pool(processes=16) #프로세스 개수
    pool.map(count, num_list)
    pool.close()
    pool.join()

print("--- %s seconds ---" % (time.time() - start_time))
#num_list 4개일 때
#프로세스 2개 : 8.11427354812622 seconds
#프로세스 4개 : 7.632588624954224 seconds
#프로세스 8개 : 7.9008448123931885 seconds
#프로세스 16개 : 8.183116674423218 seconds

#num_list 8개일 때
#프로세스 2개 : 8.314736366271973 seconds
#프로세스 4개 : 8.138237237930298 seconds
#프로세스 8개 : 7.221688508987427 seconds
#프로세스 16개 : 7.265570640563965 seconds


