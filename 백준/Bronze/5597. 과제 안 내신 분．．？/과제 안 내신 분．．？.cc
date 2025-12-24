#include <iostream>

using std::cin;
using std::cout;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int *list, i;
	list = (int*)calloc(31, sizeof(int));
	for (i = 0; i < 28; i++) {
		cin >> list[0];
		list[list[0]] = 1;
	}
	for (i = 1; i <= 30; i++)
		if (list[i] == 0)
			cout << i << "\n";
	return 0;
}