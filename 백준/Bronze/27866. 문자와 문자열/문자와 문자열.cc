#include <iostream>

using std::cin;
using std::cout;
using std::string;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	string str;
	int a;

	cin >> str;
	cin >> a;
	cout << str.substr(a-1, 1);

	return 0;
}