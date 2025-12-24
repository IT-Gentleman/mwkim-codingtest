#include <iostream>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int num, max, min, * list, i;
	cin >> num;
	list = (int*)malloc(sizeof(int) * num);
	cin >> list[0];
	max = list[0]; min = list[0];
	for (i = 1; i < num; i++) {
		cin >> list[i];
		if (list[i] < min) min = list[i];
		if (list[i] > max) max = list[i];
	}
	cout << min << " " << max;
	return 0;
}