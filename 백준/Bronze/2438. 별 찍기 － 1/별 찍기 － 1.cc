#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n, i, j;
	cin >> n;
	for (i = 0; i < n; i++, cout<<"\n") {
		for (j = 0; j <= i; j++)
			cout << "*";
	}
	return 0;
}