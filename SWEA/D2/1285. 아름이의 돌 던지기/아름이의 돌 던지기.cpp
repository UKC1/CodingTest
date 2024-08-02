#include <iostream>
#include <vector>
#include <cmath>
#include <limits>

using namespace std;

int main() {
    int T;
    cin >> T; // 테스트 케이스의 수 입력 받기
    for (int test_case = 1; test_case <= T; ++test_case) {
        int N;
        cin >> N; // 배열의 크기 입력 받기
        vector<int> arr(N);
        for (int i = 0; i < N; ++i) {
            cin >> arr[i]; // 배열의 원소 입력 받기
        }

        int minDist = numeric_limits<int>::max(); // 최소 절대값을 저장할 변수 초기화
        int minCnt = 0; // 최소 절대값을 갖는 원소의 개수를 저장할 변수 초기화

        for (int i = 0; i < N; ++i) {
            int dist = abs(arr[i]); // 원소와 0 사이의 절대값 계산
            if (dist < minDist) {
                minDist = dist; // 새로운 최소값 발견 시 갱신
                minCnt = 1; // 최소값 갱신 시 개수 초기화
            } else if (dist == minDist) {
                ++minCnt; // 최소값과 같은 절대값을 갖는 원소 개수 증가
            }
        }

        cout << "#" << test_case << " " << minDist << " " << minCnt << endl;
    }
    return 0;
}
