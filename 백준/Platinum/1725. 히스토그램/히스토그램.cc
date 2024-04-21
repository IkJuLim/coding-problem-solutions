#include <iostream>
#include <algorithm>

using namespace std;

int histogram[100001];

int recall(int start, int end){
    if (start == end)
        return histogram[start];

    int mid = (start + end) / 2;
    int ret = histogram[mid];
    int h = histogram[mid];
    int l = mid - 1;
    int r = mid + 1;
    while (start <= l || r <= end){
        if (start > l){
            h = min(h, histogram[r]);
            r++;
        }else if (r > end){
            h = min(h, histogram[l]);
            l--;
        }else if (histogram[l] > histogram[r]){
            h = min(h, histogram[l]);
            l--;
        }else {
            h = min(h, histogram[r]);
            r++;
        }
        ret = max(ret, (r - l - 1) * h);
    }

    return max(ret, max(recall(start, mid), recall(mid + 1, end)));
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> histogram[i];

    cout << recall(0, n - 1);
    return 0;
}