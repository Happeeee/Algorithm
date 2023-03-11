#include <bits/stdc++.h>
using namespace std;

int n, k, sum;
int arr[100005];
vector<int> v;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> k;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	for (int i = 0; i < k; i++)
		sum += arr[i];

	v.push_back(sum);

	for (int i = 1; i <= n - k; i++) {
		sum -= arr[i - 1];
		sum += arr[i + k - 1];

		v.push_back(sum);
	}

	cout << *max_element(v.begin(), v.end());

	return 0;
}