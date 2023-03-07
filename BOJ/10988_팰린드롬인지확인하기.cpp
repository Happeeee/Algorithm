#include <bits/stdc++.h>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string s, rev;

	cin >> s;

	rev = s;

	reverse(rev.begin(), rev.end());

	if (s == rev)
		cout << "1";
	else
		cout << "0";
}