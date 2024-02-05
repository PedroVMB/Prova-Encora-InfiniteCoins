import java.util.List;

public class Main {
    public static void main(String[] args) {
        float value = 12;
        List<List<Integer>> result = CoinChange.makeChange(value);
        for (List<Integer> resultList : result) {
            System.out.println(resultList);
        }
    }
}