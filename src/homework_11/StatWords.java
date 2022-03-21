package homework_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class StatWords {
    public static void main(String[] args) {
        String[] wordsArray = {"Привет", "Пока", "Здравствуй", "До свидание", "привет", "пока", "здравствуй", "до свидание",
                "Привет", "Пока", "Здравствуй", "До свидание", "привет", "пока", "здравствуй", "до свидание",
                "Привет", "Пока", "Здравствуй", "До свидание", "привет", "пока", "здравствуй", "до свидание"};

        // сначало работаем с уникальными значениями
        // определяем вручную счетом регистра
        ArrayList<String> uni_words = get_uni_words(wordsArray, 0);
        System.out.println(uni_words);
        // определяем вручную без учета регистра
        uni_words = get_uni_words(wordsArray, 1);
        System.out.println(uni_words);
        // статистика слов
        // определяем вручную счетом регистра
        HashMap<String, Integer> stata = getStatWords(wordsArray, 0);
        System.out.println(stata);
        // статистика слов
        // определяем вручную без учета регистра
        stata = getStatWords(wordsArray, 1);
        System.out.println(stata);
    }

    private static HashMap<String, Integer> getStatWords(String[] words, int register) {
        HashMap<String, Integer> stat = new HashMap<>();
        if (register == 0) {
            for (String word : words) {
                if (stat.containsKey(word)) {
                    stat.put(word, stat.get(word) + 1);
                } else {
                    stat.put(word, 1);
                }
            }
        } else {
            for (String word : words) {
                if (stat.containsKey(word.toLowerCase())) {
                    stat.put(word.toLowerCase(), stat.get(word.toLowerCase()) + 1);
                } else {
                    stat.put(word.toLowerCase(), 1);
                }
            }
        }

        return stat;

    }

    private static ArrayList<String> get_uni_words(String[] words, int register) {
        ArrayList<String> uwords = new ArrayList<>();
        if (register == 0) {
            for (String word : words) {
                if (!uwords.contains(word)) {
                    uwords.add(word);
                }
            }
        } else {
            boolean flag;
            for (String word : words) {
                flag = true;
                for (String uword : uwords ){
                    if (uword.toLowerCase().equals(word.toLowerCase())){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    uwords.add(word);
                }
            }
        }


        return uwords;
    }
}
