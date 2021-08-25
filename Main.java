import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static boolean validateCard(String card) {
        ArrayList<Integer> cards = new ArrayList<>();

        if(card.length() < 14 || card.length() > 19) {
            return false;
        }

        int sum = 0;

        char[] charsCard = card.toCharArray();

        for(char i: charsCard) {
            cards.add(Integer.parseInt(String.valueOf(i)));
        }

        int check = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);

        Collections.reverse(cards);

        int count = 0;

        for(Integer m: cards) {
            if(count % 2 == 0) {
                int newNum = m*2;
                if(newNum >= 10) {
                    int mergedNum = 0;
                    char[] addNums = String.valueOf(newNum).toCharArray();
                    for(char n: addNums) {
                        mergedNum += Integer.parseInt(String.valueOf(n));
                    }
                    cards.set(count, mergedNum);
                } else {
                    cards.set(count, newNum);
                }
            }
            count++;
        }

        for(Integer l: cards) {
            sum += l;
        }

        int lastDigit = sum % 10;

        return (10 - lastDigit == check);
    }


    public static void main(String[] args) {
        // shows that a valid card returns true and a invalid card returns false
        System.out.println(validateCard("1234567890123456"));
        System.out.println(validateCard("1234567890123452"));
    }
}
