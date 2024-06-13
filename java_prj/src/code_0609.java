// 대괄호로 블럭 나누기 -> 함수
// class명 = file명
// main 함수 가장 먼저 실행

class code_0609 {

	public static void main(String[] args) {
		// init : 초기화

		int kor1;
		int kor2;
		int kor3;
		int total;
		float avg;

		kor1 = 30;
		kor2 = 40;
		kor3 = 100;

		// result : 연산 결과
		total = kor1 + kor2 + kor3;
		avg = (float) total / 3;

		// 출력
		System.out.printf("\nkor1 is %d\n", kor1);
		System.out.printf("kor2 is %d\n", kor2);
		System.out.printf("kor3 is %d\n", kor3);
		System.out.printf("total is %d\n", total);
		System.out.printf("average is %.2f\n", avg);

	}
}