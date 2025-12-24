#include <iostream>
#include <cmath>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	int n;
	cin >> n;
	cout << (int)pow((int)pow(2, n)+1,2);

	return 0;
}