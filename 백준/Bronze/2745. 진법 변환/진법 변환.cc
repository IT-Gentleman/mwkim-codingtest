#include <iostream>
#include <cstring>
#include <string>
#include <cmath>

using std::cin;
using std::cout;
using std::string;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	string n;
	int b, sum = 0;
	cin >> n;
	cin >> b;
	for (int i = 0; i < n.length(); i++) {
		if (n[n.length() - i-1] >= 'A' && n[n.length()-i-1] <= 'Z')
			sum += (n[n.length() - i - 1] - 'A' + 10) * pow(b, i);
		else
			sum += (n[n.length() - i - 1] - '0') * pow(b, i);
	}
	cout << sum;

	return 0;
}