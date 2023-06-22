#include <bits/stdc++.h>
#include <algorithm>
#include <string.h>
using namespace std;

int main() {
	int result = 0;
	string s;

	cin >> s;

	result = (int)s[0] - 48; // 첫번째 수 받아오고 만약 한자리 수라면 아래 반복문 넘어가서 그대로 출력

	for (int i = 1; i < s.size(); i++) {
		int next = (int)s[i] - 48; // 다음 숫자

		if (result <= 1 || next <= 1) // 둘 중 하나라도 0 또는 1이라면 더하고
			result += next;
		else
			result *= next; // 아니라면 곱하는게 더 큰 숫자가 되는 길
	}

	cout << result;

}
