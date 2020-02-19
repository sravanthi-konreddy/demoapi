import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sudoku {

	private static TreeMap<String, List<Integer>> map = new TreeMap<String, List<Integer>>();
	private static List<Integer> list1 = new ArrayList<Integer>();
	private static List<String> fixedList = new ArrayList<String>();
	private static List<String> marked = new ArrayList<String>();
	private static int val1 = 0;
	private static int val2 = 0;
	private static boolean toSolve = false;

	public static void main(String[] args) {
		int[][] inputArray = new int[9][9];
		inputArray[0][0] = 0;inputArray[0][1] = 0;inputArray[0][2] = 0;inputArray[0][3] = 8;inputArray[0][4] = 0;inputArray[0][5] = 1;inputArray[0][6] = 0;inputArray[0][7] = 0;inputArray[0][8] = 0;
		inputArray[1][0] = 0;inputArray[1][1] = 0;inputArray[1][2] = 0;inputArray[1][3] = 0;inputArray[1][4] = 0;inputArray[1][5] = 0;inputArray[1][6] = 4;inputArray[1][7] = 3;inputArray[1][8] = 0;
		inputArray[2][0] = 5;inputArray[2][1] = 0;inputArray[2][2] = 0;inputArray[2][3] = 0;inputArray[2][4] = 0;inputArray[2][5] = 0;inputArray[2][6] = 0;inputArray[2][7] = 0;inputArray[2][8] = 0;
		inputArray[3][0] = 0;inputArray[3][1] = 0;inputArray[3][2] = 0;inputArray[3][3] = 0;inputArray[3][4] = 7;inputArray[3][5] = 0;inputArray[3][6] = 8;inputArray[3][7] = 0;inputArray[3][8] = 0;
		inputArray[4][0] = 0;inputArray[4][1] = 0;inputArray[4][2] = 0;inputArray[4][3] = 0;inputArray[4][4] = 0;inputArray[4][5] = 0;inputArray[4][6] = 1;inputArray[4][7] = 0;inputArray[4][8] = 0;
		inputArray[5][0] = 0;inputArray[5][1] = 2;inputArray[5][2] = 0;inputArray[5][3] = 0;inputArray[5][4] = 3;inputArray[5][5] = 0;inputArray[5][6] = 0;inputArray[5][7] = 0;inputArray[5][8] = 0;
		inputArray[6][0] = 6;inputArray[6][1] = 0;inputArray[6][2] = 0;inputArray[6][3] = 0;inputArray[6][4] = 0;inputArray[6][5] = 0;inputArray[6][6] = 0;inputArray[6][7] = 7;inputArray[6][8] = 5;
		inputArray[7][0] = 0;inputArray[7][1] = 0;inputArray[7][2] = 3;inputArray[7][3] = 4;inputArray[7][4] = 0;inputArray[7][5] = 0;inputArray[7][6] = 0;inputArray[7][7] = 0;inputArray[7][8] = 0;
		inputArray[8][0] = 0;inputArray[8][1] = 0;inputArray[8][2] = 0;inputArray[8][3] = 2;inputArray[8][4] = 0;inputArray[8][5] = 0;inputArray[8][6] = 6;inputArray[8][7] = 0;inputArray[8][8] = 0;
		for (int i = 1; i <= 9; i++) {
			list1.add(i);
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)

			{
				List<Integer> list2 = new ArrayList<Integer>();
				list2.addAll(list1);
				map.put(String.valueOf(i) + String.valueOf(j), list2);
			}
		}

		findFixed(inputArray);
System.out.println("Partial Solution::::");

		for (int[] row : inputArray) {
			System.out.println(Arrays.toString(row));
		}
		calculateTrialAndError(inputArray);

		System.out.println(
				":::::::::::::::::::::::::::::::::::::::::After Trial and Error:::::::::::::::::::::::::::::::::::::::");

		for (int[] row : inputArray) {
			System.out.println(Arrays.toString(row));
		}

		

		findFixed(inputArray);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)

			{
				List<Integer> list2 = new ArrayList<Integer>();
				list2.addAll(list1);
				if (map.containsKey(String.valueOf(i) + String.valueOf(j))) {
					map.get(String.valueOf(i) + String.valueOf(j)).clear();
					map.get(String.valueOf(i) + String.valueOf(j)).addAll(list2);
				}
			}
		}}

	private static void calculateTrialAndError(int[][] inputArray) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map.containsKey(String.valueOf(i) + String.valueOf(j))) {
					Collections.sort(map.get(String.valueOf(i) + String.valueOf(j)));
				}
			}
		}
		solve(inputArray);

	}

	private static void solve(int[][] inputArray) {

		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(list1);
		System.out.println("Hi");
		int temp = 0;
		int temp1 = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = temp1; j < 9; j++) {

				temp = j;
				if (map.containsKey(String.valueOf(i) + String.valueOf(j))) {

					map.get(String.valueOf(i) + String.valueOf(j)).clear();
					map.get(String.valueOf(i) + String.valueOf(j)).addAll(list2);
					calculatePossibilities(inputArray, i, j);
					if (map.get(String.valueOf(i) + String.valueOf(j)).size() > 0 && inputArray[i][j] == 0) {
						inputArray[i][j] = map.get(String.valueOf(i) + String.valueOf(j)).get(0);
					} else {
						backtrack(inputArray, i, j, true);
						toSolve = false;
						temp = j;
						int i1 = i;
						int j1 = temp + 1;
						for (i = i1; i < 9; i++) {
							for (j1 = temp + 1; j1 < 9; j1++) {
								if (map.containsKey(String.valueOf(i) + String.valueOf(j1))) {
									map.get(String.valueOf(i) + String.valueOf(j1)).clear();
									map.get(String.valueOf(i) + String.valueOf(j1)).addAll(list2);
									calculatePossibilities(inputArray, i, j1);
								}
							}

							temp = -1;
						}
						i = i1;

					}
				}
			}

		}

	}

	private static Object backtrack(int[][] inputArray, int i, int j, boolean fromSolve) {
		if (fromSolve) {
			val1 = i;
			val2 = j;
		}
		List<Integer> list2 = new ArrayList<Integer>();
		if (toSolve)
			return null;
		list2.addAll(list1);
		int flag = 0;
		int flag1 = 0;
		int k1 = 0, l1 = 0;
		int temp = j;
		int temp3 = 0;
		int temp4 = 0;
		for (k1 = i; k1 >= 0; k1--) {
			flag1 = 0;
			for (l1 = j - 1; l1 >= 0; l1--) {
				if (map.containsKey(String.valueOf(k1) + String.valueOf(l1))) {
					if (map.get(String.valueOf(k1) + String.valueOf(l1)).size() > 1) {
						map.get(String.valueOf(k1) + String.valueOf(l1)).remove(0);
						inputArray[k1][l1] = map.get(String.valueOf(k1) + String.valueOf(l1)).get(0);
					} else {
						continue;
					}
					int temp1 = 0, temp2 = 0;
					int t1 = k1;
					int t2 = l1;
					int m = k1;
					int n = l1 + 1;
					// int m=0,n=0;
					int ctemp1 = k1;
					int ctemp = l1;
					int m1 = ctemp1;
					int n1 = ctemp;

					for (m1 = t1; m1 <= val1; m1++) {
						for (n1 = t2 + 1; n1 < 9; n1++) {
							if (map.containsKey(String.valueOf(m1) + String.valueOf(n1))) {
								if ((m1 < val1 && n1 <= 8) || (m1 == val1 && n1 <= val2)) {
									inputArray[m1][n1] = 0;
								} else {
									flag1 = 1;
									break;
								}
							}

						}
						if (flag1 == 1) {
							flag1 = 0;
							break;
						}

						t2 = -1;
					}

					for (m = ctemp1; m <= val1; m++) {
						flag1 = 0;
						flag = 0;
						for (n = ctemp + 1; n <= 8; n++) {
							if ((m < val1 && n <= 8) || (m == val1 && n <= val2)) {
								if (map.containsKey(String.valueOf(m) + String.valueOf(n))) {

									map.get(String.valueOf(m) + String.valueOf(n)).clear();
									map.get(String.valueOf(m) + String.valueOf(n)).addAll(list2);
									calculatePossibilities(inputArray, m, n);

									if (map.get(String.valueOf(m) + String.valueOf(n)).size() >= 1) {
										inputArray[m][n] = map.get(String.valueOf(m) + String.valueOf(n)).get(0);
										if (m == val1 && n == val2) {
											flag1 = 1;
											toSolve = true;
											return null;
										}
										ctemp1 = m;
										ctemp = n;

									} else {

										backtrack(inputArray, m, n, false);
										if (toSolve) {
											return null;
										}
										continue;

									}
								}
							} else {
								flag1 = 2;
							}

						}
						if (flag1 == 2)
							break;
						ctemp = -1;
					}
					if (flag1 == 2)
						break;

				}
				if (flag1 == 2)
					break;

			}
			j = 9;

		}
		return null;

	}

	private static void findFixed(int[][] inputArray) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (inputArray[i][j] != 0) {
					fixedList.add(String.valueOf(i) + String.valueOf(j));
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (inputArray[i][j] == 0) {
					calculatePossibilities(inputArray, i, j);
				} else {
					map.remove(String.valueOf(i) + String.valueOf(j));
				}

			}
		}
		int count = 0;
		while (true) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (inputArray[i][j] == 0) {
						if (map.containsKey(String.valueOf(i) + String.valueOf(j)))
							if (map.get(String.valueOf(i) + String.valueOf(j)).size() == 1) {
								inputArray[i][j] = map.get(String.valueOf(i) + String.valueOf(j)).get(0);
								map.remove(String.valueOf(i) + String.valueOf(j));
								count++;
							}
					}

				}
			}
			if (count == 0) {
				break;
			}
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (inputArray[i][j] == 0) {
						calculatePossibilities(inputArray, i, j);
					} else {
						map.remove(String.valueOf(i) + String.valueOf(j));
					}

				}
			}
			count = 0;
		}
		return;
	}

	private static void calculatePossibilities(int[][] inputArray, int i, int j) {
		int a = 0, b = 0, c = 0, d = 0;
		if (i == 0 || i == 1 || i == 2) {
			if (i == 0) {
				a = 1;
				b = 2;
			} else if (i == 1) {
				a = 0;
				b = 2;
			} else if (i == 2) {
				a = 0;
				b = 1;
			}
		} else if (i == 3 || i == 4 || i == 5) {
			if (i == 3) {
				a = 4;
				b = 5;
			} else if (i == 4) {
				a = 3;
				b = 5;
			} else if (i == 5) {
				a = 3;
				b = 4;
			}
		} else if (i == 6 || i == 7 || i == 8) {
			if (i == 6) {
				a = 7;
				b = 8;
			} else if (i == 7) {
				a = 6;
				b = 8;
			} else if (i == 8) {
				a = 6;
				b = 7;
			}
		}

		if (j == 0 || j == 1 || j == 2) {
			if (j == 0) {
				c = 1;
				d = 2;
			} else if (j == 1) {
				c = 0;
				d = 2;
			} else if (j == 2) {
				c = 0;
				d = 1;
			}
		} else if (j == 3 || j == 4 || j == 5) {
			if (j == 3) {
				c = 4;
				d = 5;
			} else if (j == 4) {
				c = 3;
				d = 5;
			} else if (j == 5) {
				c = 3;
				d = 4;
			}
		} else if (j == 6 || j == 7 || j == 8) {
			if (j == 6) {
				c = 7;
				d = 8;
			} else if (j == 7) {
				c = 6;
				d = 8;
			} else if (j == 8) {
				c = 6;
				d = 7;
			}
		}

		if (map.containsKey(String.valueOf(i) + String.valueOf(j))) {
			for (int k = 0; k < 9; k++) {
				if (map.get(String.valueOf(i) + String.valueOf(j)).contains(new Integer(inputArray[i][k]))) {
					map.get(String.valueOf(i) + String.valueOf(j)).remove(new Integer(inputArray[i][k]));
				}
				if (map.get(String.valueOf(i) + String.valueOf(j)).contains(new Integer(inputArray[k][j]))) {
					map.get(String.valueOf(i) + String.valueOf(j)).remove(new Integer(inputArray[k][j]));
				}
			}
			if (map.get(String.valueOf(i) + String.valueOf(j)).contains(new Integer(inputArray[a][c]))) {
				map.get(String.valueOf(i) + String.valueOf(j)).remove(new Integer(inputArray[a][c]));
			}
			if (map.get(String.valueOf(i) + String.valueOf(j)).contains(new Integer(inputArray[a][d]))) {
				map.get(String.valueOf(i) + String.valueOf(j)).remove(new Integer(inputArray[a][d]));
			}
			if (map.get(String.valueOf(i) + String.valueOf(j)).contains(new Integer(inputArray[b][c]))) {
				map.get(String.valueOf(i) + String.valueOf(j)).remove(new Integer(inputArray[b][c]));
			}
			if (map.get(String.valueOf(i) + String.valueOf(j)).contains(new Integer(inputArray[b][d]))) {
				map.get(String.valueOf(i) + String.valueOf(j)).remove(new Integer(inputArray[b][d]));
			}
		}

		return;

	}

}