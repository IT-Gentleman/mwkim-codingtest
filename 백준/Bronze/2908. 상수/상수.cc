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

	string str1, str2;
	char temp;
	cin >> str1 >> str2;
	SWAP(str1[0], str1[2], temp);
	SWAP(str2[0], str2[2], temp);
	if (stoi(str1) > stoi(str2))
		cout << str1;
	else
		cout << str2;
	return 0;
}