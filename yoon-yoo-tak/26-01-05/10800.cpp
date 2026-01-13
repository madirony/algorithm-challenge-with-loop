#include <algorithm>
#include <cmath>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <string.h>
#include <vector>
#include <set>

#define INF 0x3f3f3f3f
#define LINF 1e18+5
#define NM 1001010
#define endl '\n'
#define all(x) x.begin(), x.end()

using namespace std;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;

int dx[8] = {1, 0, -1, 0, 1, 1, -1, -1};
int dy[8] = {0, 1, 0, -1, -1, 1, -1, 1};

int kdx[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
int kdy[8] = {-1, 1, -2, 2, -2, 2, -1, 1};


int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;
    vector<tuple<int, int, int>> arr;

    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        arr.push_back({b, a, i});
    }
    sort(all(arr));

    vector<int> sum(n + 1, 0), answer(n, 0);
    int j = 0;
    int total = 0;

    for (int i = 0; i < n; i++) {
        auto [size, color, idx] =arr[i];

        while (j < n && get<0>(arr[j]) < size) {
            int a = get<0>(arr[j]);
            int b = get<1>(arr[j]);
            total += a;
            sum[b] += a;
            j++;
        }
        answer[idx] = total - sum[color];
    }

    for (int i = 0; i < n; i++) {
        cout << answer[i] << endl;
    }



    return 0;
}
