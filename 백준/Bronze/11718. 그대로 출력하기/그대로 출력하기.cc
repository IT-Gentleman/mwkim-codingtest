#include <iostream>
#include <cstring>
#include <string>

using std::cin;
using std::cout;
using std::string;

#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	string str;
	do {
		getline(cin, str);
		cout << str << "\n";
	} while (!str.empty());
	return 0;
}