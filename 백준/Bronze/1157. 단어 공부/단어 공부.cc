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
	int* bindo, i, maxBindo=-1, maxIndex, many = 0;
	cin >> str;
	bindo = (int*)calloc(26, sizeof(int));
	for (i = 0; i < str.length(); i++) {
		if (str[i] >= 'a' && str[i] <= 'z')
			bindo[str[i] - 'a']++;
		else
			bindo[str[i] - 'A']++;
	}
	for (i = 0; i < 26; i++) {
		if (bindo[i] > maxBindo) {
			maxIndex = i;
			many = 0;
			maxBindo = bindo[i];
		}
		else if (bindo[i] == maxBindo)
			many = 1;
	}
	if (many)
		cout << "?";
	else
		cout << char(maxIndex + 'A');

	return 0;
}