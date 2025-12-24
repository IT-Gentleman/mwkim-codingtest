#include <iostream>
#include <string.h>
#include <cstring>

using std::cin;
using std::cout;
using std::string;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	char str[100];
	int num, i;
	cin >> num;
	for (i = 0; i < num; i++) {
		cin >> str;
		cout << str[0] << str[strlen(str) - 1] << "\n";
	}
	return 0;
}