package RandomNumberExample;

public class MethodExecution {

    public static void main(String[] args) throws InterruptedException {
        TargetMethods methods = new FindRandomNum();
             methods.RandomNumberCreation();
             /*Thread.sleep(2000);
             methods.FilePathCreation();
             Thread.sleep(2000);
             methods.JsonFileCreation();
             Thread.sleep(2000);
             methods.FileReading();*/

    }

}
