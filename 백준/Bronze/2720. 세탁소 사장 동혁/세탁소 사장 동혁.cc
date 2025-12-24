#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	static int amount[] = {25, 10, 05, 01};
	int inputI;
	int n;
	cin >> n;
	for (int j = 0; j < n; j++) {
		cin >> inputI;
		for (int i = 0; i < 4; i++) {
			cout << inputI / amount[i] << " ";
			inputI %= amount[i];
		}
		cout << "\n";
	}

	return 0;
}