package com.dpkg.adventofcode.y2020;

import java.util.*;
import java.util.stream.Collectors;

public class Day1 {
    public static int calculatePart2() {
        List<Integer> input = getIntegers();
        for (int num1 : input) {
            for (int num2 : input) {
                for (int num3 : input) {
                    if (isSum2020(num1, num2, num3)) {
                        System.out.println(num1 + " & " + num2 + " & " + num3);
                        return num1 * num2 * num3;
                    }
                }
            }
        }
        throw new RuntimeException("bad input");
    }



    public static int calculatePart1() {
        List<Integer> input = getIntegers();
        for (int num1 : input) {
            for (int num2 : input) {
                if (isSum2020(num1, num2)) {
                    System.out.println(num1 + " & " + num2);
                    return num1 * num2;
                }
            }
        }
        throw new RuntimeException("bad input");
    }

    private static boolean isSum2020(int... numbers) {
        return 2020 == Arrays.stream(numbers).sum();
    }

    private static List<Integer> getIntegers() {
        String inputString = "1742\n" +
        "1763\n" +
                "1238\n" +
                "1424\n" +
                "1736\n" +
                "1903\n" +
                "1580\n" +
                "1847\n" +
                "1860\n" +
                "1933\n" +
                "1779\n" +
                "1901\n" +
                "1984\n" +
                "1861\n" +
                "1769\n" +
                "1896\n" +
                "1428\n" +
                "2010\n" +
                "1673\n" +
                "1491\n" +
                "1996\n" +
                "1746\n" +
                "1973\n" +
                "1696\n" +
                "1616\n" +
                "2006\n" +
                "1890\n" +
                "1600\n" +
                "1991\n" +
                "1724\n" +
                "1804\n" +
                "1794\n" +
                "462\n" +
                "1706\n" +
                "2002\n" +
                "1939\n" +
                "1834\n" +
                "1312\n" +
                "1943\n" +
                "1465\n" +
                "1405\n" +
                "1459\n" +
                "1659\n" +
                "1288\n" +
                "1241\n" +
                "1935\n" +
                "1294\n" +
                "1388\n" +
                "1772\n" +
                "1945\n" +
                "1649\n" +
                "813\n" +
                "1956\n" +
                "1274\n" +
                "1686\n" +
                "1404\n" +
                "1770\n" +
                "1631\n" +
                "1366\n" +
                "1321\n" +
                "1353\n" +
                "1685\n" +
                "1365\n" +
                "1738\n" +
                "1911\n" +
                "1235\n" +
                "1495\n" +
                "1837\n" +
                "1456\n" +
                "1283\n" +
                "1929\n" +
                "1326\n" +
                "1735\n" +
                "1604\n" +
                "1223\n" +
                "1261\n" +
                "1844\n" +
                "1850\n" +
                "1429\n" +
                "277\n" +
                "1848\n" +
                "1818\n" +
                "1395\n" +
                "1522\n" +
                "1863\n" +
                "1475\n" +
                "1562\n" +
                "1351\n" +
                "1538\n" +
                "1313\n" +
                "1416\n" +
                "1690\n" +
                "1539\n" +
                "1338\n" +
                "1982\n" +
                "1297\n" +
                "1821\n" +
                "780\n" +
                "1859\n" +
                "1420\n" +
                "1934\n" +
                "1303\n" +
                "1731\n" +
                "1714\n" +
                "1702\n" +
                "1417\n" +
                "1872\n" +
                "1998\n" +
                "1908\n" +
                "1957\n" +
                "1270\n" +
                "1359\n" +
                "1760\n" +
                "1997\n" +
                "1773\n" +
                "2000\n" +
                "1203\n" +
                "1880\n" +
                "1955\n" +
                "1273\n" +
                "1775\n" +
                "1893\n" +
                "1237\n" +
                "1707\n" +
                "1885\n" +
                "1900\n" +
                "1801\n" +
                "1367\n" +
                "1561\n" +
                "1524\n" +
                "1678\n" +
                "1511\n" +
                "1623\n" +
                "1464\n" +
                "1477\n" +
                "1733\n" +
                "1423\n" +
                "1575\n" +
                "1851\n" +
                "2007\n" +
                "1651\n" +
                "804\n" +
                "1836\n" +
                "1849\n" +
                "1713\n" +
                "1401\n" +
                "1502\n" +
                "1806\n" +
                "1506\n" +
                "1646\n" +
                "1968\n" +
                "1253\n" +
                "1889\n" +
                "1759\n" +
                "1734\n" +
                "1611\n" +
                "1558\n" +
                "1256\n" +
                "1657\n" +
                "1778\n" +
                "1953\n" +
                "1578\n" +
                "1717\n" +
                "1498\n" +
                "1381\n" +
                "1919\n" +
                "1512\n" +
                "1391\n" +
                "384\n" +
                "1802\n" +
                "1573\n" +
                "1940\n" +
                "1323\n" +
                "2003\n" +
                "1689\n" +
                "1936\n" +
                "1368\n" +
                "1962\n" +
                "1964\n" +
                "1586\n" +
                "1619\n" +
                "1482\n" +
                "1445\n" +
                "372\n" +
                "1792\n" +
                "96\n" +
                "1468\n" +
                "1999\n" +
                "1301\n" +
                "1757\n" +
                "1613\n" +
                "1807\n" +
                "1941\n" +
                "1642\n" +
                "1557\n" +
                "1884\n" +
                "1626\n" +
                "489\n" +
                "1989\n" +
                "1327\n";
        return Arrays.stream(inputString.split("\n"))
                .map(v -> Integer.parseInt(v.trim()))
        .collect(Collectors.toUnmodifiableList());
    }
}