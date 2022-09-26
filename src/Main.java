public class Main {

    public static void main(String[] args){

        Birth caviar = (new Birth("икра"));
        Birth trout = (new Birth("форель"));

        try {
            caviar.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Первым появилось:");
        if (trout.thread.isAlive()){
            System.out.print(" икра");
        }else{
            System.out.print(" форель");
        }
    }

}
class Birth implements Runnable {

    Thread thread;

    public Birth(String name) {
        thread = new Thread(this, name);
        thread.start();
    }
    public void run() {
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName());

        }
    }
}
