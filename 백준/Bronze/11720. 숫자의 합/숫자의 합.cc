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

	int n, i, sum = 0;;
	char str[100];
	cin >> n;
	for (i = 0; i < n; i++) {
		cin >> str[i];
		sum += str[i]-'0';
	}
	cout << sum;
	return 0;
}