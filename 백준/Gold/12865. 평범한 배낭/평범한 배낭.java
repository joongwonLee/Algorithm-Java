import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, K;
    static ArrayList<Product> products;

    static int[] dpTable;
    static int maxValue;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(stn.nextToken());

        products = new ArrayList<>();

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(stn.nextToken());
            int V = Integer.parseInt(stn.nextToken());

            products.add(new Product(W, V));
        }
    }

    static void solve() {

        dpTable = new int[K+1];

        // 물품의 개수만큼
        for(int i=0; i<products.size(); i++) {

            Product p = products.get(i);
//            // 물품이 선택되었는지 체크하는 배열
//            boolean[] isSelected  = new boolean[K+1];
//
//            // 무게 1부터 K까지 모든 테이블 갱신
//            for(int j=1; j<=K; j++) {
//                if(j < p.weight) continue;
//                // 물품의 value를 더했을 때 기존의 dpTable 보다 크다면
//                if(dpTable[j-p.weight] + p.value > dpTable[j]) {
//                    // 해당 상품이 기존에 선택되었는지 체크
//                    if(!isSelected[j-p.weight]) {
//                        // 아니라면, 해당 상품을 더해주고 dpTable 갱신
//                        isSelected[j] = true;
//                        dpTable[j] = dpTable[j-p.weight] + p.value;
//                    } else {
//                        // 해당 상품이 이미 추가된 상태라면, dpTable을 바로 이전 Table 값으로 갱신
//                        dpTable[j] = dpTable[j-1];
//                    }
//                }
//            }

            // 이걸 어떻게 생각해내지,,,
            for(int j=K; j - p.weight >=0; j--) {
                dpTable[j] = Math.max(dpTable[j], dpTable[j-p.weight] + p.value);
            }

        }
    }

    static void output() {
        System.out.println(dpTable[K]);
    }
}

class Product implements Comparable {

    int weight;
    int value;
    boolean isSelected;

    public Product() {}
    public Product(int W, int V) {
        this.weight = W;
        this.value = V;
        this.isSelected = false;
    }


    @Override
    public int compareTo(Object o) {
        Product p = (Product) o;
        return this.weight - p.weight;
    }
}