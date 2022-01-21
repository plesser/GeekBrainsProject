package homework_04;

public class Cat extends Animal{

    float mRun;
    float mJump;

    public Cat() {
        this.mRun = 200;
        this.mJump = 2;
    }

    public Cat(float run, float jump) {
        this.mRun = run;
        this.mJump = jump;
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
}
