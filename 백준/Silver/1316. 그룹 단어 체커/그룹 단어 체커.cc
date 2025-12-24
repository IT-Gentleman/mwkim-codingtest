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

	int num, i, j, ** shown, count = 0;
	string str;
	cin >> num;
	shown = (int**)malloc(num * sizeof(int*));
	for (i = 0; i < num; i++)
		shown[i] = (int*)calloc(26, sizeof(int));
	for (i = 0; i < num; i++) {
		cin >> str;
		for (j = 0; j < str.length(); j++) {
			if (shown[i][str[j] - 'a'] == 2) {
				count--;
				j = str.length(); //반복문 즉시종료
			}
			else if (shown[i][str[j] - 'a'] == 0) {
				if(j)
					shown[i][str[j - 1] - 'a'] = 2;
				shown[i][str[j] - 'a'] = 1;
			}
		}
		count++;
	}
	cout << count;

	return 0;
}