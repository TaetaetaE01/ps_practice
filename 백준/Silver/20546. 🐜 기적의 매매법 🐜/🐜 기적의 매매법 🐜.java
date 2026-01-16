import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stockPriceList = new int[14];
        for (int i = 0; i < 14; i++) {
            stockPriceList[i] = Integer.parseInt(st.nextToken());
        }

        int bnp = bnp(money, stockPriceList);
        int timing = timing(money, stockPriceList);

        if (bnp > timing) {
            System.out.print("BNP");
        } else if (bnp == timing) {
            System.out.print("SAMESAME");
        } else {
            System.out.print("TIMING");
        }
    }

    private static int bnp(int money, int[] stockPriceList) {
        int totalStockCount = 0;
        for (int i = 0; i < stockPriceList.length; i++) {
            int stockCount = money / stockPriceList[i];
            if (stockCount > 0) {
                money -= stockPriceList[i] * stockCount;
                totalStockCount += stockCount;
            }
        }
        return money + stockPriceList[13] * totalStockCount;
    }

    private static int timing(int money, int[] stockPriceList) {
        int totalStockCount = 0;
        for (int i = 3; i < stockPriceList.length; i++) {
            int stockPrice3 = stockPriceList[i - 3]; // 3일전
            int stockPrice2 = stockPriceList[i - 2]; // 2일전
            int stockPrice1 = stockPriceList[i - 1];
            int stockPriceToday = stockPriceList[i];

            if (money > 0 &&
                stockPrice3 > stockPrice2 &&
                stockPrice2 > stockPrice1 &&
                stockPrice1 > stockPriceToday
            ) {
                int stockCount = money / stockPriceToday;
                money -= stockPriceToday * stockCount;
                totalStockCount += stockCount;
            } else if (totalStockCount > 0 &&
                stockPrice3 < stockPrice2 &&
                stockPrice2 < stockPrice1 &&
                stockPrice1 < stockPriceToday
            ) {
                money += totalStockCount * stockPriceToday;
                totalStockCount = 0;
            }
        }
        return money + stockPriceList[13] * totalStockCount;
    }
}