#include <iostream>
#include <cstring>
#include <string>

using std::cin;
using std::cout;
using std::string;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	string str;
	int i, result = 1;
	cin >> str;
	for (i = 0; i < str.length() / 2; i++)
		if (str[i] != str[str.length() - 1 - i]){
            result=0;
            break;
        }
	cout << result;

	return 0;
}