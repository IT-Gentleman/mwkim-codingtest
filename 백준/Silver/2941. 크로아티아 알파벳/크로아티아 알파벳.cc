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
	int i, count = 0;
	cin >> str;
	for (i = str.length() - 1; i >= 0; i--) {
		switch (str[i]) {
		case '=':
			switch (str[i - 1]) {
			case 'c':case 'z':case 's':
				count++;
				i--;
				if (str[i] == 'z' && str[i - 1] == 'd')
					i--;
			}
			break;
		case '-':
			switch (str[i - 1]) {
			case 'c':case 'd':
				count++;
				i--;
			}
			break;
		case 'j':
			switch (str[i - 1]) {
			case 'l':case 'n':
				count++;
				i--;
				break;
			default:
				count++;
			}
			break;
		default:
			count++;
		}
	}
	cout << count;

	return 0;
}