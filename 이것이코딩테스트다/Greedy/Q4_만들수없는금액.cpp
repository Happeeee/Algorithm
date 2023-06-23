#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

vector<int> v;
int n, target = 1;

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}

	sort(v.begin(), v.end());

	// 1 ~ (target -1) 까지 모두 만들 수 있다고 가정하고 target을 업데이트 시켜감
	for (int i : v) {
		if (target < i) // 다음 동전이 target보다 크면 target을 만들 수 없음
			break;

		target += i; // target과 같다면 그 자체로 가능
	}				 // 그보다 작다면 target - 1 까지는 만들 수 있으니 거기에 더하면 만들 수 있음

	cout << target;
}
