#include <iostream>

using std::cin;
using std::cout;

#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int n, * score, sum=0, i, max=0;
	cin >> n;
	score = (int*)malloc(n * sizeof(int));
	for (i = 0; i < n; i++) {
		cin >> score[i];
		sum += score[i];
		if (score[i] > max)
			max = score[i];
	}
	cout << (float)sum / (float)max * 100.0 / (float)n;
	return 0;
}