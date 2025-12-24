#include <iostream>

using std::cin;
using std::cout;

#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int n, m, i, j, * bag, k, temp;
	cin >> n >> m;
	bag = (int*)malloc((n+1) * sizeof(int));
	for (k = 1; k <= n; k++)
		bag[k] = k;
	for (k = 0; k < m; k++) {
		for(cin >> i >> j; i<j; i++, j--)
			SWAP(bag[i], bag[j], temp);
	}
	for (k = 1; k <= n; k++)
		cout << bag[k] << " ";
	return 0;
}