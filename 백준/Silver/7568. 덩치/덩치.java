import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();

		int arr[][] = new int[2][people];
		int rank[] = new int[people];

		for (int i = 0; i < people; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();

		}
		sc.close();
        
		for (int j = 0; j < people; j++) {
			int rankNum = 1;

			for (int n = 0; n < people; n++) {
				if (j == n) {
					continue;
				}

				if (arr[0][j] < arr[0][n] && arr[1][j] < arr[1][n]) {
					rankNum++;
				}
			}
			System.out.print(rankNum + " ");
		}
	}
}
