#include <iostream>
#include <cstring>
#include <string>

using std::cin;
using std::cout;
using std::string;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int*** matrix, n, m, i, j, l, sum;

	matrix = (int***)malloc(2 * sizeof(int**));
	cin >> n >> m;
	for (i = 0; i < 2; i++) {
		matrix[i] = (int**)malloc(n * sizeof(int*));
		for(j=0;j<n;j++){
			matrix[i][j] = (int*)malloc(m * sizeof(int));
			for (l = 0; l < m; l++)
				cin >> matrix[i][j][l];
		}
	}
	for (j = 0; j < n; j++) {
		for (l = 0; l < m; l++) {
			sum = 0;
			for (i = 0; i < 2; i++)
				sum += matrix[i][j][l];
			cout << sum << " ";
		}
		cout << "\n";
	}

	return 0;
}