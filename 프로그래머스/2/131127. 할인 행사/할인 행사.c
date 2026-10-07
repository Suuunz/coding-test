#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

int solution(const char* want[], size_t want_len, int number[], size_t number_len,
             const char* discount[], size_t discount_len) {
    int answer = 0;

    // 1. 할인 품목을 want의 인덱스로 변환 (원하는 제품이 아니면 -1)
    int* idx = (int*)malloc(sizeof(int) * discount_len);
    for (size_t i = 0; i < discount_len; i++) {
        idx[i] = -1;
        for (size_t j = 0; j < want_len; j++) {
            if (strcmp(discount[i], want[j]) == 0) {
                idx[i] = (int)j;
                break;
            }
        }
    }

    // 2. 길이 10짜리 슬라이딩 윈도우로 품목별 개수 관리
    int cnt[10] = {0};
    for (size_t i = 0; i < discount_len; i++) {
        // 오른쪽 원소 추가
        if (idx[i] != -1) cnt[idx[i]]++;

        // 윈도우가 10을 넘으면 왼쪽 원소 제거
        if (i >= 10 && idx[i - 10] != -1) cnt[idx[i - 10]]--;

        // 윈도우가 10일을 채웠으면 원하는 수량과 비교
        if (i >= 9) {
            bool ok = true;
            for (size_t j = 0; j < want_len; j++) {
                if (cnt[j] != number[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }
    }

    free(idx);
    return answer;
}