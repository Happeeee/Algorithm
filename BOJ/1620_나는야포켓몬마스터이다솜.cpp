#include <bits/stdc++.h>
using namespace std;

map<int, string> mp;
map<string, int> mp2;
int n, m, key;
string name, input;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> name;
		mp.insert({ i + 1, name });
		mp2.insert({ name, i + 1 });
	}

	for (int i = 0; i < m; i++) {
		cin >> input;
		key = atoi(input.c_str());

		if (key) {
			cout << mp[key] << "\n";
		}
		else {
			cout << mp2[input] << "\n";
		}
	}
}