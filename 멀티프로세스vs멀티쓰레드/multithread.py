import threading
import time
start_time = time.time()
def count():
    a=0
    for i in range(1000000):
        a+=1
        print(a)
    print("--- %s seconds ---" % (time.time() - start_time))

threading.Thread(target=count).start();
threading.Thread(target=count).start();

#쓰레드 2개: 21.085611820220947 seconds
#쓰레드 4개: 22.049038410186768 seconds
#쓰레드 8개: 19.222583532333374 seconds