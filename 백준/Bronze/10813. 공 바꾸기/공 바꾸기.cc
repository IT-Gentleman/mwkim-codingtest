#include <iostream>

using std::cin;
using std::cout;

#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n, m, * list, temp, i, a, b;
	cin >> n >> m;
	list = (int*)malloc(n * sizeof(int));
	for (i = 0; i < n; i++)
		list[i] = i+1;
	for (i = 0; i < m; i++) {
		cin >> a >> b;
		SWAP(list[a - 1], list[b - 1], temp);
	}
	for (i = 0; i < n; i++)
		cout << list[i] << " ";
	return 0;
}