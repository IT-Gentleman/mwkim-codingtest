#include <iostream>
#include <cstring>
#include <string>
#include <cmath>

using std::cin;
using std::cout;

int main(void) {
	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	bool noSosu[100000] = { false, };
	int countSosu=0;
	int sosu[50000];
	for (int i = 2; i < 100000 ; i++) 
		if (noSosu[i] == 0) {
			for (int j = i * 2; j < 100000; j += i)
				noSosu[j] = 1;
			sosu[countSosu++]=i;
			//cout << i << " ";
		}
	//free(noSosu);

	int n, k, max, count = 0;
	cin >> n >> k;
	for (int j = 1; j <= n; j++) {//n보다 작거나 같은 자연수
		max = 0;
		for (int i = 0; i<countSosu && sosu[i]<=j; i++) {
			if (j % sosu[i] == 0) //해당숫자의 소인수
				max = sosu[i];
		}
		if (max <= k)
			count++;
		//cout << j << "의 최대소수 " << max << " 따라서" << (max<=k) << "\n";
	}
	cout << count;
	return 0;
}
