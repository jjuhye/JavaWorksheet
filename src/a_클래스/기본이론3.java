package a_클래스;

//class Score{
//	int arr[] = {87,100,11,72,92};
//}

public class 기본이론3 {

	public static void main(String[] args) {
                  // new int[5]
		int arr[]= {87,100,11,72,92};
		
		Score s1 = new Score(); // Score클래스의 객체주소값 -> s1 지역변수 가지고있다
		System.out.println(arr);
		System.out.println(s1);
		System.out.println(s1.arr); // s1인 클래스객체 주소로 가서 그 안에 arr 값 가져왔다 
		System.out.println(s1.arr[0]); // s1 클래스주소로 가서 arr 주소로 가서 arr주소의 0번째 값을 가져와 
		
	}

}
