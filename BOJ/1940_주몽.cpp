#include <bits/stdc++.h>
using namespace std;

int n, m, input, ret;
vector<int> key;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> input;
		key.push_back(input);
	}

	for (int i : key) {
		if (find(key.begin(), key.end(), m - i) != key.end()) {
			ret++;
		}
	}

	cout << ret / 2;
}