package homework_02a;

import java.util.List;

public class Sorts {
    public static void sortBubble(List<Notebook> notebooks){
        int size = notebooks.size();
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < size - 1; i++) {
                if (notebooks.get(i).compare(notebooks.get(i + 1))) {
                    Notebook tNotebook = notebooks.get(i);
                    notebooks.set(i, notebooks.get(i + 1));
                    notebooks.set(i + 1, tNotebook);
                    flag = true;
                }
            }
        }
    }

    public static void sortChoise(List<Notebook> notebooks) {

        for (int i=0; i < notebooks.size(); i++){
            for (int j = i + 1; j < notebooks.size(); j++){
                if (notebooks.get(i).compare(notebooks.get(j))){
                    Notebook temp = notebooks.get(j);
                    notebooks.set(j, notebooks.get(i));
                    notebooks.set(i, temp);
                }
            }
        }


    }

    public static void sortChoiseMax(List<Notebook> notebooks) {

        for (int i=0; i < notebooks.size(); i++){
            for (int j = i + 1; j < notebooks.size(); j++){
                if (!notebooks.get(i).compare(notebooks.get(j))){
                    Notebook temp = notebooks.get(j);
                    notebooks.set(j, notebooks.get(i));
                    notebooks.set(i, temp);
                }
            }
        }


    }
}
