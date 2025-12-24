#include <iostream>
//#include <cstring>
//#include <string>

using std::cin;
using std::cout;
//using std::string;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int input, row, col, max = 0, i, j;
	for (i = 0; i < 9; i++) {
		for (j = 0; j < 9; j++) {
			cin >> input;
			if (input >= max) {
				row = i; col = j; max = input;
			}
		}
	}
	cout << max << "\n" << row+1 << " " << col+1;

	return 0;
}