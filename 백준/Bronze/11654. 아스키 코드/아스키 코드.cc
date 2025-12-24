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

	char str;
	cin >> str;
	cout << (int)str;
	return 0;
}