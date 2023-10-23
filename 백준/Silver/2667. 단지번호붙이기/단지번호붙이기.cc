//
//  BJ2667.cpp
//  SeSACAlgorithm
//
//  Created by 이중원 on 2022/11/12.
//

#include "bits/stdc++.h"

using namespace std;

int N;
vector<int> v[26 * 26];
vector<int> countV;
bool check[26][26];
bool flag;
int id, cnt;
int arr[25][25];

bool in(int x, int y) {
    return 0 <= x && x <= N - 1 && 0 <= y && y <= N - 1;
}


void dfs(int x, int y, int id) {
    check[x][y] = true;
    
    for(int i = 0; i < 4; i++) {
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int next_x = x + dx[i];
        int next_y = y + dy[i];
        if(in(next_x, next_y) && check[next_x][next_y] == false && arr[next_x][next_y] == 1) {
            cnt++;
            dfs(next_x, next_y, id);
        }
    }
}

int main(int argc, const char* argv[]) {
    ios::sync_with_stdio(0); cin.tie(0);

    cin >> N;
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            char c;
            cin >> c;
            if ( c == '1') { arr[i][j] = 1; }
        }
    }
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
            if(check[i][j] == false && arr[i][j] == 1) {
                dfs(i, j, id++);
                countV.push_back(cnt);
                cnt = 0;
            }
        }
    }
    
    sort(countV.begin(), countV.end());
    
    cout << id << '\n';
    for(int i = 0; i < countV.size(); i++) {
        cout << countV[i] + 1 << '\n';
    }
        
    return 0;
}
