#include <iostream>

using std::cin;
using std::cout;

int findMax(int*, int*, int);

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int* score = NULL, * maxScore = NULL;
	int n, i;

	cin >> n;
	if (n < 1 || n > 300) {
		cout << "N is not appropriate. End of program\n";
		return 0;
	}
	score = new int[n + 1];
	score[0] = 0;
	for (i = 1; i <= n; i++)
		cin >> score[i];

	cout << findMax(score, maxScore, n);

	delete[] score;
	delete[] maxScore;
	return 0;
}

//bottom-up 방식 채택
int findMax(int* score, int* maxScore, int n) {
	int i, prev = 0;
	maxScore = new int[n + 1]; maxScore[0] = 0, maxScore[1] = 0;
	for (i = 0; i < n; i++) { //i=n-1까지 수행(n-1에서는 i+1(n에 저장)만 수행)
		// i 칸을 빈칸으로, i+1 (& i+2)칸을 밟고, 종료된 칸에 값 저장
		/*  i=0은 출발칸 의미, 출발칸 직후 1개 또는 2개 발판 밟는다는 의미
		 *  출발칸 다음칸 밟지 않는 경우는 i=1 에서 계산 (1번째칸 안밟음)    */
		 //i+1 저장 시 이전 i+2한 값과 비교하여 큰값 저장 (더 큰값이라면 덮어쓰기)
		if (prev + score[i + 1] > maxScore[i + 1])
			maxScore[i + 1] = prev + score[i + 1];
		//i==n-1일 때, i+2=n+1으로써 주소값 잘못 참조하기에 skip
		if (i < n - 1)
			maxScore[i + 2] = prev + score[i + 1] + score[i + 2];
		prev = maxScore[i];
	}
	return maxScore[n];
}