#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int num, * list, find, i, count=0;
	cin >> num;
	list = (int*)malloc(sizeof(int) * num);
	for (i = 0; i < num; i++)
		cin >> list[i];
	cin >> find;
	for (i = 0; i < num; i++)
		if (list[i] == find)
			count++;
	cout << count;
	return 0;
}