package lesson2;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ATM {
    private final Map<Integer, Integer> banknotes;

    public ATM() {
        banknotes = new TreeMap<>(Comparator.reverseOrder());
        banknotes.put(50, 10);
        banknotes.put(100, 1);
        banknotes.put(500, 3);
        banknotes.put(1000, 7);
        banknotes.put(5000, 0);
    }

    public Map<Integer, Integer> withdraw(int amount) {
        final int START_AMOUNT = amount;
        Map<Integer, Integer> toWithdraw = new TreeMap<>(Comparator.reverseOrder());

        for (int banknote : banknotes.keySet()) {
            int neededBanknotes = Math.min(amount / banknote, banknotes.get(banknote));
            amount -= neededBanknotes * banknote;
            banknotes.put(banknote, banknotes.get(banknote) - neededBanknotes);
            toWithdraw.put(banknote, neededBanknotes);
        }

        if (amount == 0) {
            printWithdrawal(toWithdraw);
        } else {
            for (int banknote : toWithdraw.keySet()) {
                banknotes.put(banknote, banknotes.get(banknote) + toWithdraw.get(banknote));
            }
            throw new NoBanknotesToWithdrawException(START_AMOUNT);
        }

        return toWithdraw;
    }

    private void printWithdrawal(Map<Integer, Integer> toWithdraw) {
        System.out.println("Выдача:");
        for (int banknote : toWithdraw.keySet()) {
            if (toWithdraw.get(banknote) > 0) {
                System.out.println("Купюра номиналом " + banknote + ": " + toWithdraw.get(banknote) + " шт.");
            }
        }
    }

    public static void main(String[] args) {
        new ATM().withdraw(7851);
    }
}
