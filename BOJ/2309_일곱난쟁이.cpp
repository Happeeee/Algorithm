#include <bits/stdc++.h>
using namespace std;

vector<int> heights;

int height, sum = 0;
int n = 9, r = 7;

void print(vector<int> v) {
	for (int i : v) cout << i << " ";
	cout << "\n";
}

void combi(int start, vector<int> ret) {
	if (ret.size() == r) {
		int sum = accumulate(ret.begin(), ret.end(), 0);

		if (sum == 100) {
			sort(ret.begin(), ret.end());
			print(ret);
			exit(0);
		}
		return;
	}

	for (int i = start + 1; i < n; i++) {
		ret.push_back(heights[i]);
		combi(i, ret);
		ret.pop_back();
	}
}

int main() {
	for (int i = 0; i < n; i++) {
		cin >> height;
		heights.push_back(height);
	}

	vector<int> ret;
	combi(-1, ret);
	return 0;
}