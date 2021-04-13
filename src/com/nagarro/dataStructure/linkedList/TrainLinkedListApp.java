package com.nagarro.dataStructure.linkedList;

public class TrainLinkedListApp {
    BasicLinkedList<TrainCar> train = new BasicLinkedList<>();

    public static void main(String[] args) {
        TrainLinkedListApp app = new TrainLinkedListApp();
        app.buildInitialTrain();

        System.out.println(app.trainSize());

        app.firstStop();

        System.out.println("After First Stop train size: " + app.trainSize());

        app.secondStop();

        System.out.println("After Second Stop train size: " + app.trainSize());

        app.lastStop();

        System.out.println("After Last Stop train size: " + app.trainSize());
    }

    private int trainSize() {
        return train.size();
    }

    private void buildInitialTrain() {
        TrainCar car1 = new TrainCar(CarType.BOXCAR, "Amazon Packages");
        TrainCar car2 = new TrainCar(CarType.FLATBED, "Farm Machinery");
        TrainCar car3 = new TrainCar(CarType.BOXCAR, "Paper");
        TrainCar car4 = new TrainCar(CarType.BOXCAR, "Grease");
        TrainCar car5 = new TrainCar(CarType.TANKER, "Crude Oil #1");
        TrainCar car6 = new TrainCar(CarType.TANKER, "Crude Oil #2");
        TrainCar car7 = new TrainCar(CarType.TANKER, "Crude Oil #3");
        TrainCar car8 = new TrainCar(CarType.FLATBED, "Empty Shipping Container");
        TrainCar car9 = new TrainCar(CarType.HOPPER, "Wheat Grain");
        TrainCar car10 = new TrainCar(CarType.HOPPER, "Coal");

        //connect the cars
        train.insert(car1);
        train.insert(car2);
        train.insert(car3);
        train.insert(car4);
        train.insert(car5);
        train.insert(car6);
        train.insert(car7);
        train.insert(car8);
        train.insert(car9);
        train.insert(car10);

        train.print();
    }

    private void firstStop() {
        TrainCar boxcar = train.delete();

        System.out.println("First Stop: Removed - " + boxcar);

        TrainCar newBoxcar = new TrainCar(CarType.BOXCAR, "Farm Fence Posts and Barbwire");
        train.insertAt(1, newBoxcar);

        train.print();
    }

    private void secondStop() {
        TrainCar car = train.deleteAt(5);
        System.out.println("Second Stop: Removed - " + car);

        car = train.deleteAt(5);
        System.out.println("Second Stop: Removed - " + car);

        car = train.deleteAt(5);
        System.out.println("Second Stop: Removed - " + car);

        train.print();
    }

    private void lastStop() {
        try {
            while (true) {
                TrainCar car = train.delete();
                System.out.println("Last Stop: Removed - " + car);
            }
        } catch (IllegalStateException ise) {
            System.out.println("Train is now empty");
        }
        train.print();
    }

    class TrainCar {
        private CarType type;
        private String contents;

        public TrainCar(CarType carType, String carContents) {
            this.type = carType;
            this.contents = carContents;
        }

        public String toString() {
            return type.toString() + " - " + contents;
        }
    }

    enum CarType {
        BOXCAR, TANKER, FLATBED, HOPPER
    }
}
