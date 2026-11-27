class Solution {
    public long solution(int dist_limit, int split_limit) {
        if (dist_limit <= 0) {
            return 1L;
        }

        long distLimit = dist_limit;
        long splitLimit = split_limit;
        long answer = 1L;

        for (int a = 0; ; a++) {
            long pow2 = 1L << a;
            if (pow2 > splitLimit) {
                break;
            }

            long pow3 = 1L;
            for (int b = 0; ; b++) {
                if (pow2 > splitLimit / pow3) {
                    break;
                }

                if (b == 0) {
                    // 2분기 레이어만 사용하는 경우
                    long u2 = Math.min(distLimit, pow2 - 1L);
                    answer = Math.max(answer, 1L + u2);
                } else if (a == 0) {
                    // 3분기 레이어만 사용하는 경우
                    long maxU3 = (pow3 - 1L) / 2L;
                    long u3 = Math.min(distLimit, maxU3);
                    answer = Math.max(answer, 1L + 2L * u3);
                } else {
                    // 2분기 a개 레이어 이후 3분기 b개 레이어 배치
                    long halfPow2 = pow2 >>> 1; // 2^(a-1), 마지막 2분기 레이어 최대 노드 수
                    long cap3Unit = pow3 - 1L;  // 마지막 2분기 노드 1개당 3분기 최대 수용량

                    // uMin(x) + x * (3^b - 1) <= distLimit 를 만족하는 최대 x 탐색
                    long lo = 1L;
                    long hi = halfPow2;
                    long x0 = 0L;
                    while (lo <= hi) {
                        long mid = (lo + hi) >>> 1;
                        long h = calcUMin(mid, a) + mid * cap3Unit;
                        if (h <= distLimit) {
                            x0 = mid;
                            lo = mid + 1L;
                        } else {
                            hi = mid - 1L;
                        }
                    }

                    if (x0 >= 1L) {
                        answer = Math.max(answer, eval(x0, a, halfPow2, cap3Unit, distLimit));
                    }
                    if (x0 + 1L <= halfPow2) {
                        answer = Math.max(answer, eval(x0 + 1L, a, halfPow2, cap3Unit, distLimit));
                    }
                }

                if (pow3 > splitLimit / 3L) {
                    break;
                }
                pow3 *= 3L;
            }
        }

        return answer;
    }

    // 깊이 a에 x개의 분배 노드를 두기 위한 2분기 노드 최소 합
    private long calcUMin(long x, int a) {
        long sum = 0L;
        long cur = x;
        for (int i = 0; i < a; i++) {
            sum += cur;
            cur = (cur + 1L) >>> 1;
        }
        return sum;
    }

    // 마지막 2분기 레이어 노드 수가 x일 때의 최대 리프 수 계산
    private long eval(long x, int a, long halfPow2, long cap3Unit, long distLimit) {
        long uMin = calcUMin(x, a);
        if (uMin > distLimit) {
            return 0L;
        }

        long uMax = (halfPow2 - 1L) + x;
        long cap3 = x * cap3Unit;

        // 1 + u2 + 2 * min(distLimit - u2, cap3)의 최댓값 위치로 u2 조정
        long upperU2 = Math.min(distLimit, uMax);
        long u2 = distLimit - cap3;
        if (u2 < uMin) {
            u2 = uMin;
        } else if (u2 > upperU2) {
            u2 = upperU2;
        }

        long u3 = Math.min(distLimit - u2, cap3);
        return 1L + u2 + 2L * u3;
    }
}