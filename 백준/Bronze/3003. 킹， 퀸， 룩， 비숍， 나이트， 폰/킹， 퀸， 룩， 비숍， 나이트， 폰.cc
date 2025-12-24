#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int present[6], normal[6] = { 1,1,2,2,2,8 };

	for (int i = 0; i < 6; i++) {
		cin >> present[i];
		cout << normal[i] - present[i] << " ";
	}

	return 0;
}