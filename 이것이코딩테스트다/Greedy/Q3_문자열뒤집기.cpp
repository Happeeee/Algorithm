#include <bits/stdc++.h>
#include <algorithm>
#include <string.h>
using namespace std;

string s;
int c[2];

int main() {

	cin >> s;

	for (int i = 1; i < s.size(); i++) {
		if (s[i - 1] == '0' && s[i] == '1') {
			c[0]++; // 0 -> 1 일때 0의 개수 증가
		}
		else if (s[i - 1] == '1' && s[i] == '0') {
			c[1]++; // 1 -> 일때 1의 개수 증가
		}
	}

	c[(int)s[s.size() - 1] - 48]++; // 마지막 숫자는 다음으로의 변화가 없어서 카운트가 안되므로 직접 확인

	cout << min(c[0], c[1]);

}
