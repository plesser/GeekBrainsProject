package homework_02a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Process {
    public static void main(String[] args) {
        int size = 10000;

        List<Notebook> notebooks = new ArrayList<>();
        for (int i=0; i<size; i++){
            notebooks.add(Notebook.getNotebook());
            //System.out.println(notebooks.get(i).toString());
        }

        //System.out.println("--------------------------------------------------");
        long begin = new Date().getTime();
        Sorts.sortChoise(notebooks);
        long end = new Date().getTime();
        System.out.println("Time: " + (end - begin));


        /*
        for (Notebook notebook : notebooks){
            System.out.println(notebook);
        }
         */

    }

}
