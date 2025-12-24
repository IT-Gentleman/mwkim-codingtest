#include <stdio.h>
#include <string.h>

int main(void) {
	char str[100];
	int alpha[26], i;

	scanf("%s", str);
	for (i = 0; i < 26; i++)
		alpha[i] = -1;
	for (i = 0; i < strlen(str); i++)
		if (alpha[str[i] - 'a'] == -1)
			alpha[str[i] - 'a'] = i;
	for (i = 0; i < 26; i++)
		printf("%d ", alpha[i]);
	return 0;
}