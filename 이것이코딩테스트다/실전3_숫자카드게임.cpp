#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

int main() {
	int n, m, x, max_value = 0;

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		int min_value = 10001;
		for (int j = 0; j < m; j++) {
			cin >> x;
			min_value = min(x, min_value);
		}
		max_value = max(min_value, max_value);
	}

	cout << max_value;
}