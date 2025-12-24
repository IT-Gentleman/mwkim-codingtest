#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int a;
	cin >> a;
	switch (a / 10) {
	case 10:case 9:
		cout << "A";
		break;
	case 8:
		cout << "B";
		break;
	case 7:
		cout << "C";
		break;
	case 6:
		cout << "D";
		break;
	default:
		cout << "F";
	}
	return 0;
}