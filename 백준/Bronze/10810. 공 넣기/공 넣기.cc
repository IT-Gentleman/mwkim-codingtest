#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n, m, * bag, i, a, b, c, j;
	cin >> n >> m;
	bag = (int*)calloc(n, sizeof(int));
	for (i = 0; i < m; i++) {
		cin >> a >> b >> c;
		for (j = a-1; j <= b-1; j++)
			bag[j] = c;
	}
	for (i = 0; i < n; i++)
		cout << bag[i] << " ";
	return 0;
}