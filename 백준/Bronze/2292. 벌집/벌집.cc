#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int input, i = 1, j = 1;
	cin >> input;
	while (i < input) {
		i += (++j - 1) * 6;
	}
	cout << j;

	return 0;
}