#include <iostream>
#include <cstring>

using std::cin;
using std::cout;
using std::string;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int n, i, j, k;
	char str[30];
	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> j;
		cin >> str;
		for (int m = 0; m < strlen(str); m++)
			for (k = 0; k < j; k++)
				cout << str[m];
		cout << "\n";
	}
	return 0;
}