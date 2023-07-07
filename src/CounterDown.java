public class CounterDown {

    public void myFunctionCounterDown(String parameter){
        boolean temp1=false;
        Settings settings=new Settings();
        int numb=Integer.parseInt(parameter);
        boolean test=false;
        do{
            numb--;
            try{
                Thread.sleep(1000, 10);
            }catch (Exception e){
                System.out.println(e);
            }
            test=true;
        }while (numb>0);
        if (test){
            NewFrame newFrame=new NewFrame();
            newFrame.newFrame();
        }
    }
}
