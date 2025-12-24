#include <iostream>

using std::cin;
using std::cout;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int* list;
	int i, count = 0;
	list = (int*)calloc(43, sizeof(int));
	for (i = 0; i < 10; i++) {
		cin >> list[42];
		list[list[42]%42] = 1;
	}
	for (i = 0; i < 42; i++)
		if (list[i] == 1) count++;
	cout << count;
	return 0;
}