#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int num, find, * list, i;
	cin >> num >> find;
	list = (int*)malloc(sizeof(int) * num);
	for (i = 0; i < num; i++) {
		cin >> list[i];
		if (list[i] < find)
			cout << list[i] << " ";
	}
	return 0;
}