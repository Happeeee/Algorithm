#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

int main() {
	// N�� �ſ� Ŀ���� ���� �����ؼ� �ѹ��� ���� ���
	int n, k, target, count = 0;

	cin >> n >> k;

	while (true) {
		target = (n / k) * k; // k�� ���� �� �ִ� n�� ã��
		count += n - target; // 1�� ���ٰ� �������� ���� count
		n = target;

		if (n < k) break;
		n /= k;
		count++;
	}

	count += n - 1;

	cout << count;
}