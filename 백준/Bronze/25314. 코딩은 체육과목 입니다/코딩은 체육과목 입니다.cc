#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int a;
	cin >> a;
	for (int i = 0; i < a/4; i++)
		cout << "long ";
	cout << "int";
	return 0;
}