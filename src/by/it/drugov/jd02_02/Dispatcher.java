package by.it.drugov.jd02_02;

class Dispatcher {
    static final int K_SPEED = 10;
    private volatile static int countEnterToMarket = 0;
    private volatile static int countOutFromMarket = 0;
    volatile static int countBuyersInQueue = 0;
    static synchronized void buyerEnterToMarket() {
        //Object monitor = Dispatcher.class;
        countEnterToMarket++;
    }
    static synchronized void buyerLeaveMarket() {
        countOutFromMarket++;
    }
    static synchronized int increaseCountBuyersInQueue() {
        countBuyersInQueue++;
        return  countBuyersInQueue;
    }
    static synchronized void decreaseCountBuyersInQueue() {
        countBuyersInQueue--;
    }
    static boolean marketIsOpenedForNewBuyer(){
        return countEnterToMarket!=PLAN;
    }
    static boolean marketIsClosed(){
        return countOutFromMarket==PLAN;
    }
    static int PLAN = 100;


}
