//https://programmers.co.kr/learn/courses/30/lessons/81302

class Solution {

    public boolean check(String[][] places, int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (Math.abs(x - i) == 2 && y == j) {
                    if (places[i][j].equals("P")) {
                        System.out.println("check1 " + i + " " + j);
                        if (i > x) {
                            if (places[x + 1][y].equals("X") == false) {
                                return false;
                            }
                        } else {
                            if (places[x - 1][y].equals("X") == false) {
                                return false;
                            }
                        }
                    }
                } else if (Math.abs(y - j) == 2 && x == i) {
                    if (places[i][j].equals("P")) {
                        System.out.println("check2 " + i + " " + j);
                        if (j > y) {
                            if (places[x][y + 1].equals("X") == false) {
                                return false;
                            }
                        } else {
                            if (places[x][y - 1].equals("X") == false) {
                                return false;
                            }
                        }
                    }
                } else if ((Math.abs(x - i) + Math.abs(y - j)) == 2) {
                    if (places[i][j].equals("P")) {
                        System.out.println("check3 " + i + " " + j);
                        int tempX = 0;
                        int tempY = 0;
                        if (i > x)
                            tempX = x + 1;
                        else
                            tempX = x - 1;
                        if (j > y)
                            tempY = y + 1;
                        else
                            tempY = y - 1;

                        if (places[tempX][y].equals("X") == false) {
                            return false;
                        }
                        if (places[x][tempY].equals("X") == false) {
                            return false;
                        }
                    }
                } else if ((Math.abs(x - i) + Math.abs(y - j)) == 1) {
                    if (places[i][j].equals("P")) {
                        System.out.println("check4 " + i + " " + j);
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int roomN = 0;
        for (String[] place : places) {
            String[][] room = new String[5][5];
            int row = 0;
            for (String str : place) {
                room[row] = str.split("");
                row++;
            }
            System.out.println("new room");
            boolean ill = true;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (room[x][y].equals("P")) {
                        System.out.println(x + " " + y);
                        if (check(room, x, y) == false) {
                            answer[roomN] = 0;
                            ill = false;
                            break;
                        }
                    }
                }
                if (ill == false) {
                    break;
                }
            }

            if (ill == true) {
                answer[roomN] = 1;
            }
            roomN++;
        }

        return answer;
    }
}