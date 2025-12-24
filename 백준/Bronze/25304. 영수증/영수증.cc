#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int sum, n, a, b;
	cin >> sum >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		sum -= a * b;
	}
	if (sum == 0)
		cout << "Yes";
	else
		cout << "No";
	return 0;
}