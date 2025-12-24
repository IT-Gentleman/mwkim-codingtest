#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int a=0, b=0;
	while (cin >> a >> b)
		cout << a + b << "\n";
	return 0;
}