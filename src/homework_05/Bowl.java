package homework_05;

public class Bowl {
    float mVolume;
    float mFood;

    public Bowl(float volume) {
        this.mVolume = volume;
        this.mFood = 0;
    }

    public Bowl() {
        this.mVolume = 10;
        this.mFood = 0;
    }

    public boolean putFood(float eat) {
        boolean res = true;
        if (eat + mFood <= mVolume){
            mFood += eat;
        } else {
            res = false;
        }

        return res;
    }
    public boolean putFood() {
        boolean res = true;
        mFood = mVolume;

        return res;
    }
    public float getVolume() {
        return mVolume;
    }

    public float getFood() {
        return mFood;
    }


    // Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
    // Вот этот пункт не совсем понятен, когда еда в тарелке есть но коту мало или когда еда исходит на ноль
    // реализую кторой вариант, так как в теории у кота изначально может быть аппетит больше чем объем тарелки
    public boolean eat(float volume){
        boolean res = true;
        if (volume > mFood){
            res = false;
        } else {
            mFood -= volume;
        }

        if (mFood == 0.0){
            System.out.println("Bowl is empty and me add to bowl " + mVolume + " units food");
            mFood = mVolume;
        }

        return res;
    }


}
