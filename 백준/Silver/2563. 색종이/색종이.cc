#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int n, a, b, i, j, l, sum=0;
	bool** area;
	area = (bool**)malloc(100 * sizeof(bool*));
	for (i = 0; i < 100; i++)
		area[i] = (bool*)calloc(100, sizeof(bool));

	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> a >> b;
		for (j = a; j < a + 10; j++)
			for (l = b; l < b + 10; l++) {
				if (area[j][l] == 0)
					sum++;
				area[j][l] = 1;
			}
	}
	cout << sum;

	return 0;
}