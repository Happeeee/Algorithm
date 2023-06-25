#include <bits/stdc++.h>

using namespace std;

vector<int> v;
int n, m, k, result;

int main() {
    cin >> n >> m >> k;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        v.push_back(x);
    }
    sort(v.begin(), v.end(), greater<>()); 

    int first = v[0]; // 가장 큰 수
    int second = v[1]; // 두 번째로 큰 수

    int count = (m / (k + 1)) * k; // 가장 큰 수가 더해지는 횟수 : 수열 반복 횟수 * k
    count += m % (k + 1); // 두번째로 큰 수가 더해지는 횟수 : 수열 반복 횟수와 동일

    result += count * first; // 가장 큰 수 더하기
    result += (m - count) * second; // 두 번째로 큰 수 더하기

    cout << result << '\n'; // 최종 답안 출력
}
