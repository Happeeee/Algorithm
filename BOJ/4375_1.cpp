#include <bits/stdc++.h>
using namespace std;

long long n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while (cin >> n) {
		long long ret = 1, i = 1;
		while (1) {
			if ((ret % n) == 0) {
				cout << i << "\n";
				break;
			}
			else {
				ret = (ret * 10) % n + 1 % n;
				i++;
			}
		}
	}
}