import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {
    public static List<List<Integer>> makeChange(float value) {
        List<List<Integer>> resultArrays = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        makeChangeRecursive(value, 0, 0, 0, 0, new ArrayList<>(), resultSet);
        resultArrays.addAll(resultSet);
        return resultArrays;
    }

    private static void makeChangeRecursive(float remainingValue, int quarters, int dimes, int nickels, int pennies,
                                            List<Integer> currentChange, Set<List<Integer>> resultSet) {
        if (remainingValue == 0) {
            resultSet.add(new ArrayList<>(currentChange));
            return;
        }

        if (remainingValue >= 25) {
            currentChange.add(quarters + 1);
            makeChangeRecursive(remainingValue - 25, quarters + 1, dimes, nickels, pennies, currentChange, resultSet);
            currentChange.remove(currentChange.size() - 1);
        }

        if (remainingValue >= 10) {
            currentChange.add(dimes + 1);
            makeChangeRecursive(remainingValue - 10, quarters, dimes + 1, nickels, pennies, currentChange, resultSet);
            currentChange.remove(currentChange.size() - 1);
        }

        if (remainingValue >= 5) {
            currentChange.add(nickels + 1);
            makeChangeRecursive(remainingValue - 5, quarters, dimes, nickels + 1, pennies, currentChange, resultSet);
            currentChange.remove(currentChange.size() - 1);
        }

        if (remainingValue >= 1) {
            currentChange.add(pennies + 1);
            makeChangeRecursive(remainingValue - 1, quarters, dimes, nickels, pennies + 1, currentChange, resultSet);
            currentChange.remove(currentChange.size() - 1);
        }
    }
}
