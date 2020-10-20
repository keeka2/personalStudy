package sssssssssssssssssss;



class Sum{
	int num=0;
	int sum(){
		for(int i=0;i<1000;i++) {
			num+=1;
		}
		return num;
	}
}

	 

class ThreadEX implements Runnable{
	 Sum s = new Sum();
	 public void run() {
	 String threadName = Thread.currentThread().getName(); //쓰레드 이름 받아오기
	 synchronized(s) {
		 System.out.println(threadName+" : "+s.sum());
		 }
	 }
}

class ThreadEX2 implements Runnable{
	 Sum s = new Sum();
	 public void run() {
		 String threadName = Thread.currentThread().getName(); //쓰레드 이름 받아오기
		 System.out.println(threadName+" : "+s.sum());
	 }
}

public class ThreadSynchronize {

	public static void main(String[] args) {
		 Runnable r = new ThreadEX();
		 Thread ex1 = new Thread(r,"a"); //첫번째 쓰레드 객체 생성 쓰레드 이름은 a
		 Thread ex2 = new Thread(r,"b"); //두번째 쓰레드 객체 생성 쓰레드 이름은 b
		 //멀티 쓰레드 시작
		 ex1.start(); 
		 ex2.start();
		 
		 Runnable r2 = new ThreadEX2();
		 ex1 = new Thread(r2,"a"); //첫번째 쓰레드 객체 생성 쓰레드 이름은 a
		 ex2 = new Thread(r2,"b"); //두번째 쓰레드 객체 생성 쓰레드 이름은 b
		 //멀티 쓰레드 시작
		 ex1.start(); 
		 ex2.start();
	}
}

//res
a : 1000
b : 2000
a : 1001
b : 1047
