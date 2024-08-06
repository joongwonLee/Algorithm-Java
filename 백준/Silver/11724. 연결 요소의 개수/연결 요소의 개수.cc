#include "bits/stdc++.h"

using namespace std;

int N, M, cnt;

vector<int> v[1010];
bool check[1010];

void dfs(int node) {

    check[node] = true;

    for(int i = 0; i < v[node].size(); i++) {
        int next = v[node][i];
        if(check[next] == false) {
            dfs(next);
        }
    }
}

int main(int argc, const char* argv[]) {
    ios::sync_with_stdio(0); cin.tie(0);

    cin >> N >> M;

    for(int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;

        v[a].push_back(b);
        v[b].push_back(a);

    }

    for(int i = 1; i <= N; i++) {
        if (check[i] == false) {
            dfs(i);
            cnt++;
        }
    }

    cout << cnt << '\n';

    return 0;
}