#include <bits/stdc++.h>
using namespace std;

int cnt[26];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string input;

	cin >> input;

	for (char a : input) cnt[a - 'a']++;

	for (int i : cnt) cout << i << " ";
}