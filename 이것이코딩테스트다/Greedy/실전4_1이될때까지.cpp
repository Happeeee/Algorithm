#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

int main() {
	// N이 매우 커졌을 때를 가정해서 한번에 빼는 방법
	int n, k, target, count = 0;

	cin >> n >> k;

	while (true) {
		target = (n / k) * k; // k로 나눌 수 있는 n을 찾기
		count += n - target; // 1씩 뺐다고 생각했을 때의 count
		n = target;

		if (n < k) break;
		n /= k;
		count++;
	}

	count += n - 1;

	cout << count;
}