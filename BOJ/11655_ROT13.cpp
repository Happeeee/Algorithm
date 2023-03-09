#include <bits/stdc++.h>
using namespace std;

string s;

void ROT13() {
	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 'a' && s[i] <= 'z') {
			if (s[i] + 13 > 'z')
				s[i] = s[i] + 13 - 26;
			else
				s[i] += 13;
		}

		if (s[i] >= 'A' && s[i] <= 'Z') {
			if (s[i] + 13 > 'Z')
				s[i] = s[i] + 13 - 26;
			else
				s[i] += 13;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	getline(cin, s);

	ROT13();

	cout << s;
}