package homework_05;

public class UnitCases {
    public static void main(String[] args) {
        // сначало тестируем тарелку
        //checkBowl();

        System.out.println("------------------------------------");
        // Тестируем на единственном коте
        //checkCat();

        System.out.println("------------------------------------");
        // Тестируем на куче коте
        checkArrayCats();

        System.out.println("------------------------------------");

    }

    private static void checkArrayCats() {
        Bowl bowl = new Bowl(20);
        bowl.putFood(20);

        Cat catArray[] = new Cat[10];
        // Создаем котов и сразу же кормим их
        for (int i=0; i < catArray.length; i++){
            Cat cat = new Cat(bowl);
            catArray[i] = cat;
            cat.eat();
        }

        for (int i=0; i < catArray.length; i++){
            System.out.println("Cat number #" + i + " is satiety? " + catArray[i].mSatiety);
        }

        // делаем всем котам аппетит 5 (кратное объему тарелки для теста последнего пункта дз)
        bowl.putFood();
        for (int i=0; i < catArray.length; i++){
            catArray[i].setAppetite(5);
        }

        for (int i=0; i < catArray.length; i++){
            catArray[i].eat();
        }
        for (int i=0; i < catArray.length; i++){
            System.out.println("Cat number #" + i + " is satiety? " + catArray[i].mSatiety);
        }

    }

    private static void checkCat() {
        Bowl bowl = new Bowl(20);
        bowl.putFood(20);
        Cat cat = new Cat(bowl);
        cat.eat();
    }

    private static void checkBowl() {
        Bowl bowl = new Bowl();
        System.out.println("Volume of bowl: " + bowl.getVolume());
        System.out.println("Eat of bowl: " + bowl.getFood());

        System.out.println("Check eat 5 units food: " + bowl.eat(5f));
        System.out.println("Eat of bowl: " + bowl.getFood());

        System.out.println("Check put to bowl 20 units eat: " + bowl.putFood(20f));
        System.out.println("Eat of bowl: " + bowl.getFood());

        System.out.println("Check put to bowl 20 units eat: " + bowl.putFood(10f));
        System.out.println("Eat of bowl: " + bowl.getFood());

        System.out.println("Check eat 15 units food: " + bowl.eat(15f));
        System.out.println("Eat of bowl: " + bowl.getFood());
        System.out.println("Check eat 4 units food: " + bowl.eat(4f));
        System.out.println("Eat of bowl: " + bowl.getFood());
    }
}
