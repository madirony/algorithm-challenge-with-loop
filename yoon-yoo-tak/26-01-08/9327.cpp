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

    int t;
    cin >> t;
    while (t--) {
        int n, e;
        cin >> n >> e;

        vector<int> arr(n);
        ll total = 0;
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
            total += arr[i];
        }

         ll target = (e + 1) / 2;

        if (target == 0) {
            cout << 0 << endl;
            continue;
        }

        if (total < target) {
            cout << "FULL" << endl;
            continue;
        }

        int max = total;

        vector<bool> dp(max + 1, 0);
        dp[0] = 1;

        for (int i : arr) {
            for (int j = max; j >= i; j--) {
                if (dp[j - i]) dp[j] = 1;
            }
        }
        int answer = -1;
        for (int i = target; i <= max; i++) {
            if (dp[i]) {
                answer = i;
                break;
            }
        }
        if (answer == -1) {
            cout << "FULL" << endl;
        }else {
            cout << answer << endl;
        }
    }

    return 0;
}
