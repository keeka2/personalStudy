class MyThread extends Thread{
    public static long sum;
    private int start, end;

    public MyThread(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long temp = 0;
        for(int i=start; i<=end;i++){
            temp+=i;
        }
        sum+=temp;
    }
}

public class MultiThreading {
    //자바는 process가 존재하지 않고 스레드 개념만 존재함(멀티스래딩만 지원)
    public static void main(String[] args) throws InterruptedException {
        //단일(Main 쓰레드)---------------------------//
        // 0.59초 / 1999999999000000000
        long start = System.currentTimeMillis();
        long sum = 0;
        for(int i=0;i<2000000000;i++){
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("단일 쓰레드");
        System.out.println(sum);
        System.out.println("시간: "+(end-start)/1000.0);
        System.out.println();
        //--------------------------------------------//

        //멀티쓰레드------------------------------------//
        start = System.currentTimeMillis();
        MyThread.sum=0;
        int threadCount = 8;
        int target = 2000000000;
        MyThread[] threads = new MyThread[threadCount];
        for(int i=0; i<threads.length; i++){
            threads[i] = new MyThread(i*(target/threadCount),(i+1)*(target/threadCount)-1);
            //start로 시작해야 병렬처리, run으로 할 경우 스택으로 쌓여 병렬X
            threads[i].start();
        }

        for(int i=0;i<threads.length;i++){
            //해당 쓰레드가 종료되기까지 기다렸다가 다음으로 넘어감
            threads[i].join();
        }
        end = System.currentTimeMillis();
        System.out.println(MyThread.sum);
        System.out.println("시간: "+(end-start)/1000.0);
        //1999999999000000000
        //시간: 0.287
    }
}
