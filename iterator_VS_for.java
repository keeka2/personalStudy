package algorithm_practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iterator_VS_for {
	//iterator : 순차적조회 방법 자체를 숨길수가 있다, 반복이 발생하는 방식의 내부 구조를 캡슐화
	//속도차이는 거의 없음

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<1000000;i++) {
			list.add(i);
		}
		long beforeTime = System.currentTimeMillis();
		int k = 0;
		for(Integer i : list) {
			System.out.println(i);
			k=i;
		}
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime1 = (afterTime - beforeTime); //두 시간에 차 계산
	
		
		Iterator<Integer> it = list.iterator();
		beforeTime = System.currentTimeMillis();
		k = 0;
		while(it.hasNext()) {
			k=it.next();
			System.out.println(k);
		}
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime2 = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime1);
		System.out.println("시간차이(m) : "+secDiffTime2);

	}

}
