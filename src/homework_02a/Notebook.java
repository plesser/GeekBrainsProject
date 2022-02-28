package homework_02a;

import java.util.Arrays;
import java.util.Random;

public class Notebook {
    private int price;
    private int ram;
    private String vendor;

    public Notebook(String vendor, int ram, int price) {
        this.price = price;
        this.ram = ram;
        this.vendor = vendor;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public String getVendor() {
        return vendor;
    }

    private static String[] vendors = {"Lenove", "Asus", "MacNote", "Xiamiou"};

    public static Notebook getNotebook(){
        Random rand = new Random();
        int price = rand.nextInt(4) * 500 + 500;
        int ram = rand.nextInt(6) * 4 + 4;
        int vendorId = rand.nextInt(4);

        //System.out.println("Vendor: " + vendors[vendorId] + " Ram: " + ram + " Price: " + price);


        Notebook notebook = new Notebook(vendors[vendorId], ram, price);

        return notebook;
    }

    public boolean compare(Notebook notebook){
        boolean res = false;
        if (this.price > notebook.getPrice()){
            res = true;
        } else if (this.price < notebook.getPrice()){
            res = false;
        } else {
            if (this.ram > notebook.getRam()){
                res = true;
            } else if (this.ram < notebook.getRam()){
                res = false;
            } else {
                //System.out.println(this.vendor + " " + Arrays.asList(Notebook.vendors).indexOf(this.vendor));

                if (Arrays.asList(Notebook.vendors).indexOf(this.vendor) <= Arrays.asList(Notebook.vendors).indexOf(notebook.getVendor())){
                    res = false;
                } else if (Arrays.asList(Notebook.vendors).indexOf(this.vendor) > Arrays.asList(Notebook.vendors).indexOf(notebook.getVendor())){
                    res = true;
                }

            }
        }

        return res;
    }


    public static void unit() {
        Random rand = new Random();
        int step = 0;
        for (int i=0; i < 1000; i++){
            int price = (rand.nextInt(4)) * 500 + 500;
            System.out.print(price + " ");
            step++;
            if (step == 20){
                System.out.println();
                step = 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", ram=" + ram +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
