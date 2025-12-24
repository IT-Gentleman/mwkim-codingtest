#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int max=0, index, i, temp;
	for (i = 0; i < 9; i++) {
		cin >> temp;
		if (temp>max) {
			max = temp;
			index = i;
		}
	}
	cout << max << "\n" << index+1;
	return 0;
}