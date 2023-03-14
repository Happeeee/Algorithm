#include <bits/stdc++.h>
using namespace std;

string s, result;
int cnt[26];
int odd_cnt = 0, odd_index;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> s;

	for (int i = 0; i < s.size(); i++)
		cnt[s[i] - 'A']++;

	for (int i = 0; i < 26; i++) { // Ȧ���� �ְ� �ϳ����̶�� �ε����� �����صα�
		if (cnt[i] % 2 != 0) {
			odd_index = i;
			odd_cnt++;
		}

		if (odd_cnt > 1) {
			cout << "I'm Sorry Hansoo";
			return 0;
		}
	}

	if (odd_cnt == 1) { // Ȧ���� �־��ٸ� Ȧ���� ��� ���� ����
		result += (char)('A' + odd_index);
		cnt[odd_index]--;
	}

	// AAAAAABBBBBBCCCCCCDDEEO
	// 6 6 6 2 2 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 ...

	for (int i = 25; i >= 0; i--) {
		for (int j = 0; j < cnt[i] / 2; j++) {
			result = (char)('A' + i) + result;
			result = result + (char)('A' + i);
		}
	}

	cout << result;


}