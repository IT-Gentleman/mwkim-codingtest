#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int a=0, b=0;
	do {
		if (!(a == 0 && b == 0))
			cout << a + b << "\n";
		cin >> a >> b;
	} while (!(a == 0 && b == 0));
	return 0;
}