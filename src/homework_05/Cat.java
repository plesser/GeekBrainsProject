package homework_05;

public class Cat extends Animal {

    float mRun;
    float mJump;
    float mAppetite;
    boolean mSatiety;

    Bowl mBowl;

    public Cat(Bowl bowl) {
        this.mRun = 200;
        this.mJump = 2;
        this.mAppetite = 3;
        this.mBowl = bowl;
        this.mSatiety = false;
    }

    public Cat(float run, float jump, float appetite, Bowl bowl) {
        this.mRun = run;
        this.mJump = jump;
        this.mAppetite = appetite;
        this.mBowl = bowl;
        this.mSatiety = false;
    }

    @Override
    public boolean run(float val) {
        boolean res = true;
        if (val <= mRun){
            System.out.println("cat run " + val);
        } else {
            System.out.println("cat not run");
            res = false;
        }
        return res;
    }

    @Override
    public boolean sail(float val) {
        boolean res = false;
        System.out.println("cat not sail");
        return res;
    }

    @Override
    public boolean jump(float val) {
        boolean res = true;
        if (val <= mJump){
            System.out.println("cat jump " + val);
        } else {
            System.out.println("cat not jump");
            res = false;
        }

        return res;
    }

    public void setRun(float run) {
        this.mRun = run;
    }

    public void setJump(float jump) {
        this.mJump = jump;
    }

    public void setAppetite(float appetite) {
        this.mAppetite = appetite;
    }

    public void setBowl(Bowl bowl) {
        this.mBowl = bowl;
    }

    public boolean eat(){
        boolean res = true;
        if (mBowl.getFood() < mAppetite){
            System.out.println("In bowl is food units: " + mBowl.getFood() + " but appetite this cat is " + mAppetite);
            res = false;
        } else {
            //System.out.println("Put food to cat: " + mBowl.eat(mAppetite));
            mBowl.eat(mAppetite);
            this.mSatiety = true;
            //System.out.println("In bowl is food units: " + mBowl.getFood());
        }
        return res;
    }

}
