#include <bits/stdc++.h>
using namespace std;

int cnt[26];

int n;
string s;
bool flag = false;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> s;
		cnt[s[0] - 'a']++;
	}

	for (int i : cnt) {
		if (i >= 5)
			flag = true;
	}

	if (flag) {
		for (int i = 0; i < 26; i++) {
			if (cnt[i] >= 5)
				cout << (char)(i + 'a');
		}
	}
	else {
		cout << "PREDAJA";
	}

	return 0;
}