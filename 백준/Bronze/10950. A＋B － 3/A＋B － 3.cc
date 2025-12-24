#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int num, a, b, i;
	cin >> num;
	for (i = 0; i < num; i++){
		cin >> a >> b;
		cout << a + b << endl;
	}
	return 0;
}