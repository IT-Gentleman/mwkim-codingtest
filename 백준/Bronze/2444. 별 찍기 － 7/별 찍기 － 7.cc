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

	int num, i, j;
	cin >> num;
	for (i = 0; i < num; i++) { //index=i 일 때 별 2*i+1개 출력, 공란은 num-i-1개 출력
		for (j = 1; j < num - i; j++)
			cout << " ";
		for (j = 0; j < 2 * i + 1; j++)
			cout << "*";
		cout << "\n";
	}
	for (i -= 2; i >= 0; i--) {
		for (j = 1; j < num - i; j++)
			cout << " ";
		for (j = 0; j < 2 * i + 1; j++)
			cout << "*";
		cout << "\n";
	}

	return 0;
}