#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

vector<int> v;

int main() {
	int n, x, count = 0, group = 0;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> x;
		v.push_back(x);
	}

	sort(v.begin(), v.end()); // 오름차순 정렬해서 앞에서 부터 검사

	for (int i = 0; i < v.size(); i++) {
		count++;

		if (v[i] <= count) { // 핵심 로직 : 현재 공포도가 현재 그룹원 수보다 작다면 그룹 결성 아니라면 더 가보기
			group++;
			count = 0;
		}
	}

	cout << group;
}
