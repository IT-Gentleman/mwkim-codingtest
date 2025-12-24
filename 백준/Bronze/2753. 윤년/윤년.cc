#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int a;
	cin >> a;
	if (a % 4 == 0) {
		if (a % 100 == 0) {
			if (a % 400 == 0)
				cout << "1";
			else
				cout << "0";
		}
		else
			cout << "1";
	}
	else
		cout << "0";
	return 0;
}