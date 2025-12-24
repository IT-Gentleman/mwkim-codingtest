#include <iostream>
#include <cstring>
//#include <string>

using std::cin;
using std::cout;
using std::string;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	char matrix[5][15];
	int i, j, maxSize = 0;
	for (i = 0; i < 5; i++) {
		cin >> matrix[i];
		if (strlen(matrix[i]) > maxSize)
			maxSize = strlen(matrix[i]);
	}
	for (j = 0; j < maxSize; j++) {
		for (i = 0; i < 5; i++) {
			if (strlen(matrix[i]) < j + 1);
			else
				cout << matrix[i][j];
		}
	}

	return 0;
}