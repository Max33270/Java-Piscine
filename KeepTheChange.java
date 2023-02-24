import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> change = new ArrayList<Integer>();
        if (amount == 0) {
            return change;
        }
        if (amount < 0) {
            return null;
        }
        if (coins.isEmpty()) {
            return null;
        }
        if (amount > 0 && !coins.isEmpty() && coins != null) {
            List<Integer> sortedCoins = new ArrayList<Integer>(coins);
            Collections.sort(sortedCoins, Collections.reverseOrder());
            for (int coin : sortedCoins) {
                while (amount >= coin) {
                    change.add(coin);
                    amount -= coin;
                }
            }
            if (amount != 0) {
                return null;
            }
        }
        return change;
    }
}
