// Voilation of Factory Method Pattern
// interface Logistics {
//     void send();
// }

// class Road implements Logistics {
//     @Override
//     public void send() {
//         System.out.println("BY ROAD");
//     }
// }

// class Sea implements Logistics {
//     @Override
//     public void send() {
//         System.out.println("BY SEA");
//     }
// }

// class LogisticsService {
//     public void send(String mode) {
//         if(mode == "road") {
//             Logistics logistics = new Road();
//             logistics.send();
//         } else if(mode == "sea") {
//             Logistics logistics = new Sea();
//             logistics.send();
//         }
//     }
// }
// public class Main{
//     public static void main(String[] args) {
//         LogisticsService logisticsService = new LogisticsService();
//         logisticsService.send("road");
//         System.out.println("Hello, World!");
//     }
// }

// Factory Method Pattern

// interface Logistics {
//     void send();
// }

// class Road implements Logistics {
//     @Override
//     public void send() {
//         System.out.println("BY ROAD");
//     }
// }

// class Sea implements Logistics {
//     @Override
//     public void send() {
//         System.out.println("BY SEA");
//     }
// }
// class Train implements Logistics {
//     @Override
//     public void send() {
//         System.out.println("BY Train");
//     }
// }

// class LogisticFactory {
//     public static Logistics getLogistics(String mode) {
//         if(mode.equals("road")) {
//             return new Road();
//         } else if (mode.equals("sea")) {
//             return new Sea();
//         }
//         else if (mode.equals("train")) {
//             return new Train();
//         }
//         return null;
//     }
// }

// class LogisticsService {
//     public void send(String mode) {
//         Logistics logistics = LogisticFactory.getLogistics(mode);
//         logistics.send();
//     }
// }
// public class Main{
//     public static void main(String[] args) {
//         LogisticsService logisticsService = new LogisticsService();
//         logisticsService.send("road");
//         System.out.println("Hello, World!");
//     }
// }

// //why it is reusable for other services

// // without factory method pattern

// interface Logistics {
//     void send();
// }

// class Road implements Logistics {
//     public void send() { System.out.println("BY ROAD"); }
// }

// class Sea implements Logistics {
//     public void send() { System.out.println("BY SEA"); }
// }

// class Train implements Logistics {
//     public void send() { System.out.println("BY TRAIN"); }
// }

// // 1) LogisticsService
// class LogisticsService {
//     public void send(String mode) {
//         Logistics logistics;

//         if (mode.equals("road")) logistics = new Road();
//         else if (mode.equals("sea")) logistics = new Sea();
//         else if (mode.equals("train")) logistics = new Train();
//         else throw new IllegalArgumentException("Invalid mode: " + mode);

//         logistics.send();
//     }
// }

// // 2) BillingService
// class BillingService {
//     public void generateBill(String mode) {
//         Logistics logistics;

//         if (mode.equals("road")) logistics = new Road();
//         else if (mode.equals("sea")) logistics = new Sea();
//         else if (mode.equals("train")) logistics = new Train();
//         else throw new IllegalArgumentException("Invalid mode: " + mode);

//         System.out.println("Billing for shipment...");
//         logistics.send();
//     }
// }

// // 3) TrackingService
// class TrackingService {
//     public void trackShipment(String mode) {
//         Logistics logistics;

//         if (mode.equals("road")) logistics = new Road();
//         else if (mode.equals("sea")) logistics = new Sea();
//         else if (mode.equals("train")) logistics = new Train();
//         else throw new IllegalArgumentException("Invalid mode: " + mode);

//         System.out.println("Tracking shipment...");
//         logistics.send();
//     }
// }

// // 4) AdminPanel
// class AdminPanel {
//     public void assignShipment(String mode) {
//         Logistics logistics;

//         if (mode.equals("road")) logistics = new Road();
//         else if (mode.equals("sea")) logistics = new Sea();
//         else if (mode.equals("train")) logistics = new Train();
//         else throw new IllegalArgumentException("Invalid mode: " + mode);

//         System.out.println("Admin assigned shipment...");
//         logistics.send();
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         new LogisticsService().send("road");
//         new BillingService().generateBill("sea");
//         new TrackingService().trackShipment("train");
//         new AdminPanel().assignShipment("road");
//     }
// }

// with factory method pattern

interface Logistics {
    void send();
}

class Road implements Logistics {
    @Override
    public void send() { System.out.println("BY ROAD"); }
}

class Sea implements Logistics {
    @Override
    public void send() { System.out.println("BY SEA"); }
}
    
class Train implements Logistics {
    @Override
    public void send() { System.out.println("BY TRAIN"); }
}

// Factory (ONLY ONE place has if-else)
class LogisticFactory {
    public static Logistics getLogistics(String mode) {
        if (mode.equals("road")) return new Road();
        else if (mode.equals("sea")) return new Sea();
        else if (mode.equals("train")) return new Train();
        else throw new IllegalArgumentException("Invalid mode: " + mode);
    }
}

// 1) LogisticsService
class LogisticsService {
    public void send(String mode) {
        Logistics logistics = LogisticFactory.getLogistics(mode);
        logistics.send();
    }
}

// 2) BillingService
class BillingService {
    public void generateBill(String mode) {
        Logistics logistics = LogisticFactory.getLogistics(mode);
        System.out.println("Billing for shipment...");
        logistics.send();
    }
}

// 3) TrackingService
class TrackingService {
    public void trackShipment(String mode) {
        Logistics logistics = LogisticFactory.getLogistics(mode);
        System.out.println("Tracking shipment...");
        logistics.send();
    }
}

// 4) AdminPanel
class AdminPanel {
    public void assignShipment(String mode) {
        Logistics logistics = LogisticFactory.getLogistics(mode);
        System.out.println("Admin assigned shipment...");
        logistics.send();
    }
}

public class Main {
    public static void main(String[] args) {
        new LogisticsService().send("road");
        new BillingService().generateBill("sea");
        new TrackingService().trackShipment("train");
        new AdminPanel().assignShipment("road");
    }
}
