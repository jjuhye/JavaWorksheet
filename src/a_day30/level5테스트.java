package a_day30;

public class level5테스트 {

	public static void main(String[] args) {
		//[부서정보]
		//[부서번호,부서명,지역]
		String[][] departmentData = { 
				{ "10", "ACCOUNTING", "NEW YORK" }, 
				{ "20", "RESEARCH", "DALLAS" },
				{ "30", "SALES", "CHICAGO" }, 
				{ "40", "OPERATIONS", "BOSTON" }, 
			};
		// [사원정보]
		// [번호,이름,직급,상사번호,입사일,급여,커미션,부서번호]
		String[][] employeeData = { 
				{ "7369", "SMITH", "CLERK", "7902", "17-12-1980", "800", "0", "20" },
				{ "7499", "ALLEN", "SALESMAN", "7698", "20-2-1981", "1600", "300", "30" },
				{ "7521", "WARD", "SALESMAN", "7698", "22-2-1981", "1250", "500", "30" },
				{ "7566", "JONES", "MANAGER", "7839", "2-4-1981", "2975", "0", "20" },
				{ "7654", "MARTIN", "SALESMAN", "7698", "28-9-1981", "1250", "1400", "30" },
				{ "7698", "BLAKE", "MANAGER", "7839", "1-5-1981", "2850", "0", "30" },
				{ "7782", "CLARK", "MANAGER", "7839", "9-6-1981", "2450", "0", "10" },
				{ "7788", "SCOTT", "ANALYST", "7566", "13-7-1987", "3000", "0", "20" },
				{ "7839", "KING", "PRESIDENT", "NULL", "17-11-1981", "5000", "0", "10" },
				{ "7844", "TURNER", "SALESMAN", "7698", "8-9-1981", "1500", "0", "30" },
				{ "7876", "ADAMS", "CLERK", "7788", "13-7-1987", "1100", "0", "20" },
				{ "7900", "JAMES", "CLERK", "7698", "3-12-1981", "950", "0", "30" },
				{ "7902", "FORD", "ANALYST", "7566", "3-12-1981", "3000", "0", "20" },
				{ "7934", "MILLER", "CLERK", "7782", "23-1-1982", "1300", "0", "10" }
				};	
		
		// [문제1] "DALLAS"에서 근무하는 사원의 이름,직급,부서번호,부서명을 조회하시오
		String search = "DALLAS";
		System.out.println("이름\t직급\t\t부서번호\t부서명");
		for (String[] dpD : departmentData) {
			if (search.equals(dpD[2])) {
				for (String[] emD : employeeData) {
					if (dpD[0].equals(emD[7])) {
						System.out.print(emD[1] + "\t" + emD[2] + "    \t" + emD[7] + "\t" + dpD[1] + "\n");
					}
				}
			}
		}

		// [문제2] ALLEN과 같은 부서에 근무하는 사원의 이름, 부서번호를 조회하시오.
		search = "ALLEN";
		System.out.println("===============================");
		System.out.println("이름\t부서번호");
		for (String[] emD : employeeData) {
			if (search.equals(emD[1])) {
				for (String[] emDD : employeeData) {
					if (emD[7].equals(emDD[7])) {
						if (emD[1].equals(emDD[1])) {
							continue;
						} else {
							System.out.println(emDD[1] + "\t" + emDD[7]);
						}
					}
				}
			}
		}

		// [문제3] 부서별 최대 급여와 최소 급여를 구하시오.
		int min = Integer.parseInt(employeeData[0][5]);
		int max = 0;

		System.out.println("===============================");
		System.out.println("부서명\t\t최대급여\t최소급여");
		for (int i = 0; i < departmentData.length; i++) {
			boolean check = false;
			for (int k = 1; k < employeeData.length; k++) {
				if (departmentData[i][0].equals(employeeData[k][7])) {
					int salary = Integer.parseInt(employeeData[k][5]);
					if (salary < min) {
						min = salary;
					} else {
						max = salary;
					}
					check = true;
				}
			}
			if (check) {
				System.out.println(departmentData[i][1] + "    \t" + max + "\t" + min);
			}
		}

		// [문제4] 부서별로 급여 평균 (단, 부서별 급여 평균이 2000 이상만)
		System.out.println("===============================");
		System.out.println("부서명\t\t급여평균");
		for (int i = 0; i < departmentData.length; i++) {
			int cnt = 0;
			double sum = 0;
			for (int k = 0; k < employeeData.length; k++) {
				if (departmentData[i][0].equals(employeeData[k][7])) {
					int salary = Integer.parseInt(employeeData[k][5]);
					sum += salary;
					cnt++;
				}
			}
			double avg = sum / cnt;
			if (avg >= 2000) {
				System.out.printf("%s\t%.2f\n", departmentData[i][1], avg);
			}
		}

		// [문제5] 부서번호가 30번인 사원들의 이름, 직급, 부서번호, 부서위치를 조회하시오.
		System.out.println("===============================");
		search = "30";
		System.out.println("이름\t직급\t\t부서번호\t부서위치");
		for (String[] emD : employeeData) {
			if (search.equals(emD[7])) {
				System.out.print(emD[1] + "\t" + emD[2] + "    \t" + emD[7] + "\t");
				for (String[] dpD : departmentData) {
					if (search.equals(dpD[0])) {
						System.out.print(dpD[2] + "\n");
					}
				}
			}
		}

		// [문제6] 이름에 A 가 들어가는 사원의 이름,부서명을 조회하시오.
		System.out.println("===============================");
		search = "A";
		System.out.println("이름\t부서명");
		for (String[] emD : employeeData) {
			for (int i = 0; i < emD[1].length(); i++) {
				if (search.charAt(0) == emD[1].charAt(i)) {
					System.out.print(emD[1] + "\t");
					for (String[] dpD : departmentData) {
						if (dpD[0].equals(emD[7])) {
							System.out.println(dpD[1]);
						}
					}
				}
			}
		}

		// [문제7] 사원명 'JONES'가 속한 부서명을 조회하시오.
		System.out.println("===============================");
		search = "JONES";
		System.out.println("이름\t부서명");
		for (String[] emD : employeeData) {
			if (search.equals(emD[1])) {
				System.out.print(emD[1] + "\t");
				for (String[] dpD : departmentData) {
					if (dpD[0].equals(emD[7])) {
						System.out.println(dpD[1]);
					}
				}
			}
		}

		// [문제8] 10번 부서에서 근무하는 사원의 이름과 10번 부서의 부서명을 조회하시오.
		System.out.println("===============================");
		search = "10";
		System.out.println("이름\t부서명");
		for (String[] emD : employeeData) {
			if (search.equals(emD[7])) {
				System.out.print(emD[1] + "\t");
				for (String[] dpD : departmentData) {
					if (search.equals(dpD[0])) {
						System.out.println(dpD[1]);
					}
				}
			}
		}

		// [문제9] 1987년생의사원의 이름과 직책과 부서위치 조회
		System.out.println("===============================");
		search = "1987";
		System.out.println("이름\t직책\t부서위치");
		for (String[] emD : employeeData) {
			String[] temp = emD[4].split("-");
			if (temp[2].equals(search)) {
				System.out.print(emD[1] + "\t" + emD[2] + "\t");
				for (String[] dpD : departmentData) {
					if (dpD[0].equals(emD[7])) {
						System.out.println(dpD[2]);
					}
				}
			}
		}
	}
}
