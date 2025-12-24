#include <iostream>
#include <cstring>
#include <string>
#include <cmath>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int n, b, i, length;
	cin >> n >> b;
	for (length = 0; n / pow(b, length) >= 1; length++);
	length--;
	if (length == -1)
		cout << "0";
	else
	for (i = 0; i <= length; i++) {
		if (n / (int)pow(b, length-i) > 9)
			cout << (char)((n / int(pow(b, length-i)) - 10 + 'A'));
		else
			cout << (char)((n / int(pow(b, length-i)) + '0'));
		n %= (int)pow(b, length - i);
	}
	return 0;
}