#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int a, result = 0;
	cin >> a;
	for (int i = 1; i <= a; i++)
		result += i;
	cout << result;
	return 0;
}