#include <bits/stdc++.h>
using namespace std;

int n, cnt;
string str, ret;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> str;

		stack<char> s;

		for (int i = 0; i < str.size(); i++) {
			if (s.empty())
				s.push(str[i]);
			else {
				if (s.top() == str[i])
					s.pop();
				else
					s.push(str[i]);
			}
		}

		if (s.empty())
			cnt++;
	}
	cout << cnt;
}