#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int a, b;
	cin >> a >> b;
	if (b < 45) {
		b += 60;
		if (a < 1)
			a += 24;
		a -= 1;
	}
	b -= 45;
	cout << a << " " << b;
	return 0;
}