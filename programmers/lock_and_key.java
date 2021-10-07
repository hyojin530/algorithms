//https://programmers.co.kr/learn/courses/30/lessons/60059
//자물쇠와 열쇠

class Solution {

    public int[][] makeLock(int[][] lock, int keyLength) {
        int lockLength = lock.length;
        int[][] newLock = new int[2 * (keyLength - 1) + lockLength][2 * (keyLength - 1) + lockLength];

        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                newLock[i + keyLength - 1][j + keyLength - 1] = lock[i][j];
            }
        }
        return newLock;
    }

    public int[][] match(int[][] lock, int[][] key, int x, int y, int r) {
        int keyLength = key.length;

        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (r == 0) {
                    lock[i + x][j + y] = lock[i + x][j + y] + key[i][j];
                } else if (r == 1) {
                    lock[i + x][j + y] = lock[i + x][j + y] + key[j][keyLength - i - 1];
                } else if (r == 2) {
                    lock[i + x][j + y] = lock[i + x][j + y] + key[keyLength - i - 1][keyLength - j - 1];
                } else if (r == 3) {
                    lock[i + x][j + y] = lock[i + x][j + y] + key[keyLength - j - 1][i];
                }
            }
        }

        return lock;
    }

    public boolean checkLock(int[][] lock, int start, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (lock[i + start][j + start] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int keyLength = key.length;
        int lockLength = lock.length;
        int start = keyLength - 1;

        for (int x = 0; x < start + lockLength; x++) {
            for (int y = 0; y < start + lockLength; y++) {
                for (int r = 0; r < 4; r++) {
                    int[][] newLock = makeLock(lock, keyLength);
                    int[][] matchedLock = match(newLock, key, x, y, r);
                    if (checkLock(matchedLock, start, lockLength)) {
                        return answer;
                    }
                }
            }
        }

        answer = false;
        return answer;
    }
}