#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int h, m, t;
	cin >> h >> m >> t;

	h += t / 60;

	if ((m + t % 60) / 60) {
		h += 1;
		m -= 60;
	}
	m += t % 60;

	h = h % 24;

	cout << h << " " << m;
	return 0;
}