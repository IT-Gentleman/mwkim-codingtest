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
	int time = 0, i;
	cin >> str;
	for (i = 0; i < str.length(); i++) {
		switch (str[i]){
		case 'S':case 'V':case 'Y':case 'Z':
			time--;
		}
		time += (str[i] - 'A') / 3 + 3;
	}
	cout << time;
	return 0;
}