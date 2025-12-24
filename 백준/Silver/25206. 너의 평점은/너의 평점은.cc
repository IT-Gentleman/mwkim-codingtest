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
	double value, score, sum = 0.0, valSum = 0.0;
	int i;

	for (i = 0; i < 20; i++) {
		cin >> str;
		cin >> value >> str;
		if (str.compare("F") == 0)
			valSum += value;
		else if (str.compare("P") == 0);
		else {
			score = 'A' - str[0] + 4;
			if (str[1] == '+')
				score += 0.5;
			sum += score * value;
			valSum += value;
		}
	}
	cout.precision(6);
	cout << sum/valSum;

	return 0;
}