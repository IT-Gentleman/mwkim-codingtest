#include <iostream>
#include <cstring>
#include <string>

using std::cin;
using std::cout;
using std::string;

//#define SWAP(x,y,t) ((t) = (x), (x) = (y), (y) = (t))

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	string str;
	int n = 0;
	getline(cin, str);
	for (int i = 0; i < str.length(); i++) {
		if (str[i] != ' ') {
			while (str[i] != ' ' && str[i] != '\0')
				i++;
			n++;
		}
	}
	cout << n;
	return 0;
}