package homework_04;

public class Dog extends Animal{

    float mRun;
    float mJump;
    float mSail;

    public Dog() {
        this.mRun = 500;
        this.mJump = 0.5f;
        this.mSail = 10f;
    }

    public Dog(float run, float jump, float sail) {
        this.mRun = run;
        this.mJump = jump;
        this.mSail = sail;
    }

    @Override
    public boolean run(float val) {
        boolean res = true;
        if (val <= mRun){
            System.out.println("dog run " + val);
        } else {
            System.out.println("dog not run");
            res = false;
        }
        return res;
    }

    @Override
    public boolean sail(float val) {
        boolean res = true;
        if (val <= mSail){
            System.out.println("dog sail " + val);
        } else {
            System.out.println("dog not sail");
            res = false;
        }
        return res;
    }

    @Override
    public boolean jump(float val) {
        boolean res = true;
        if (val <= mJump){
            System.out.println("dog jump " + val);
        } else {
            System.out.println("dog not jump");
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
}
