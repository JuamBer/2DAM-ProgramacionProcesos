public class Principal{
    public static void main(String args[]){
        Palillo palillo51 = new Palillo(0,true);
        Palillo palillo12 = new Palillo(1,true);
        Palillo palillo23 = new Palillo(2,true);
        Palillo palillo34 = new Palillo(3,true);
        Palillo palillo45 = new Palillo(4,true);

        Thread f1 = new Thread(new Filosofo(1,5000,3000,true,palillo51,palillo12));
        Thread f2 = new Thread(new Filosofo(2,5000,3000,true,palillo12,palillo23));
        Thread f3 = new Thread(new Filosofo(3,5000,3000,true,palillo23,palillo34));
        Thread f4 = new Thread(new Filosofo(4,5000,3000,true,palillo34,palillo45));
        Thread f5 = new Thread(new Filosofo(5,5000,3000,true,palillo45,palillo51));

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}