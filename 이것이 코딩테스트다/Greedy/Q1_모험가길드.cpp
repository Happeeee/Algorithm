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

	sort(v.begin(), v.end()); // �������� �����ؼ� �տ��� ���� �˻�

	for (int i = 0; i < v.size(); i++) {
		count++;

		if (v[i] <= count) { // �ٽ� ���� : ���� �������� ���� �׷�� ������ �۴ٸ� �׷� �Ἲ, �ƴ϶�� �� ������
			group++;
			count = 0;
		}
	}

	cout << group;
}