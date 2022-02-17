package homework_06a;

public class Process {
    public static void main(String[] args) {
        Animal animals[] = new Animal[7];
        animals[0] = new Cat("Маша", 100, 0);
        animals[1] = new Cat("Тоша", 150, 0);
        animals[2] = new Cat("Рокси", 50, 0);
        animals[3] = new Cat("Зефа", 75, 0);
        animals[4] = new Cat("Барсик", 25, 0);
        animals[5] = new Dog("Глория", 1000, 100);
        animals[6] = new Dog("Юта", 100, 10);

        animals[0].run(100);
        animals[0].run(200);
        animals[0].swim(100);


        animals[5].run(500);
        animals[5].run(2000);
        animals[5].swim(100);

        // подсчет животных
        // 1 вариант
        int cntCat = 0;
        int cntDog = 0;

        for (int i=0; i < animals.length; i++){
            if (animals[i] instanceof Cat) {
                cntCat++;
            }
            if (animals[i] instanceof Dog) {
                cntDog++;
            }
        }

        System.out.println("Итого мы имеем " + animals.length + " животных, из них " + cntCat + " кошек и " + cntDog + " собак");

        // а теперь попробуем со статикой - 2 вариант
        cntCat = Animal.getCntCat();
        cntDog = Animal.getCntDog();

        System.out.println("Итого мы имеем " + (cntCat + cntDog) + " животных, из них " + cntCat + " кошек и " + cntDog + " собак");

    }
}
