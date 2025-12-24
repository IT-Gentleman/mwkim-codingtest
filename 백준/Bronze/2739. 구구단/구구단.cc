#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int a;
	cin >> a;
	for (int i = 1; i < 10; i++) {
		cout << a << " * " << i << " = " << a * i << endl;
	}
	return 0;
}