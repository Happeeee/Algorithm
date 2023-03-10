#include <bits/stdc++.h>
using namespace std;

int n;
string p, input;

vector<string> split(string input, string delimeter) {
	vector<string> ret;
	long long pos = 0;
	string token = "";

	while ((pos = input.find(delimeter)) != string::npos) {
		token = input.substr(0, pos);
		ret.push_back(token);
		input.erase(0, pos + delimeter.length());
	}

	ret.push_back(input);

	return ret;
}

int main() {
	cin >> n;
	cin >> p;

	vector<string> v = split(p, "*");

	for (int i = 0; i < n; i++) {
		cin >> input;

		if (v[0].length() + v[1].length() > input.length()) {
			cout << "NE\n";
			continue;
		}

		if (v[0] == input.substr(0, v[0].length()) && v[1] == input.substr(input.length() - v[1].length())) {
			cout << "DA\n";
		}
		else cout << "NE\n";
	}

	return 0;
}