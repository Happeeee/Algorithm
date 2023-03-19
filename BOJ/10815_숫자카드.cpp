#include <bits/stdc++.h>
#include <unordered_set>
using namespace std;

int n, m, c;
set<int> s;
vector<int> v;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> c;
		s.insert(c);
	}

	cin >> m;

	for (int i = 0; i < m; i++) {
		cin >> c;
		v.push_back(c);
	}

	for (int i : v) {
		cout << s.count(i) << " ";
	}

}