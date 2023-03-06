#include <bits/stdc++.h>
using namespace std;

int a, b, c, in, out, fee;
int cnt[105];

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b >> c;

	for (int i = 0; i < 3; i++) {
		cin >> in >> out;

		for (int i = in; i < out; i++) {
			cnt[i]++;
		}
	}

	for (int i : cnt) {
		switch (i) {
		case 1: fee += a; break;
		case 2: fee += b * 2; break;
		case 3: fee += c * 3; break;
		}
	}

	cout << fee;
}