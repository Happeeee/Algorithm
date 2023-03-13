#include <bits/stdc++.h>
using namespace std;

int t, n;
string a, b;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> t;

	for (int i = 0; i < t; i++) {
		map<string, int> mp;

		cin >> n;
		for (int j = 0; j < n; j++) {
			cin >> a >> b;
			mp[b]++;
		}

		long long ret = 1;

		for (auto it : mp) {
			ret *= (long long)(it.second + 1);
		}

		ret--;

		cout << ret << "\n";
	}
}