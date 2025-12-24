#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n, a, b, i;
	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> a >> b;
		cout << a + b << "\n";
	}
	return 0;
}