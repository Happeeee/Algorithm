#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

int cnt[14];
int n, m, result;

int main() {
	// 1 2 2 3 3 3 4 4 4 4 
	// 동일한 수가 n 개 있다면 nC2 만큼 중복이니까 그거만큼 빼주기

	cin >> n >> m;

	result = n * (n - 1) / 2; // nC2 최대 조합 개수

	for (int i = 0; i < n; i++) { // 무게별 카운트
		int x;
		cin >> x;
		cnt[x]++;
	}

	for (int i = 1; i <= m; i++) { // 중복되면 cnt[i]C2 만큼 빼주기
		if (cnt[i] >= 2) {
			int dup = cnt[i] * (cnt[i] - 1) / 2;
			result -= dup;
		}
	}

	cout << result;

}
