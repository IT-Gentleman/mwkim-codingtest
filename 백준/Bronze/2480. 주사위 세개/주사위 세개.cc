#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int main(void) {
	int num[3], i, eq[3] = { 0,0,0 };
	int max;
	for (i = 0; i < 3; i++)
		cin >> num[i];
	for (i = 0; i < 3; i++)
		if (num[i] == num[(i + 1) % 3])
			eq[i] = 1;
	if (eq[0] * eq[1] * eq[2] == 1)
		cout << 10000 + 1000 * num[0];
	else if (eq[0] + eq[1] + eq[2] == 0) {
		max = num[0];
		for (i = 1; i < 3; i++)
			if (max < num[i])
				max = num[i];
		cout << 100 * max;
	}
	else
		for (i = 0; i < 3; i++)
			if (eq[i])
				cout << 1000 + num[i] * 100;
	return 0;
}