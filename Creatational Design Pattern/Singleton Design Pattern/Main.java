// this is Tread Safe beacause object is created at class loading time
//Eagle Loading
// class JudgeAnalytics {
//     private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();

//     private JudgeAnalytics() {
//         //no one can create a new object using new.
//     }

//     public static JudgeAnalytics getInstance() {
//         return judgeAnalytics;
//     }
// }

// this is NOt Tread Safe brcause : object is created at execution not at class loading
//Leazy Loading
// class JudgeAnalytics {
//     private static  JudgeAnalytics judgeAnalytics;

//     private JudgeAnalytics() {
//         //no one can create a new object using new.
//     }

//     public static JudgeAnalytics getInstance() {
//         if (judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();

//         }
//         return judgeAnalytics;
//     }
// }

//this is now thread safe because of synchronized is used but it is in efficient way
// leazy loading with tread safty
// class JudgeAnalytics {
//     private static JudgeAnalytics judgeAnalytics;

//     private JudgeAnalytics() {
//         //no one can create a new object using new.
//     }

//     public static synchronized JudgeAnalytics getInstance() {
//         if (judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();

//         }
//         return judgeAnalytics;
//     }
// }


//double check method
// what is volatile click-> https://www.tpointtech.com/volatile-keyword-in-java
// class JudgeAnalytics {
//     private static volatile JudgeAnalytics judgeAnalytics;

//     private JudgeAnalytics() {
//         //no one can create a new object using new.
//     }

//     public static JudgeAnalytics getInstance() {
//         if (judgeAnalytics == null) {
//             synchronized (JudgeAnalytics.class) {
//                 if (judgeAnalytics == null)
//                     judgeAnalytics = new JudgeAnalytics();
//             }

//         }
//         return judgeAnalytics;
//     }
// }

// Bill Pugs Singleton
class JudgeAnalytics {
     

    private JudgeAnalytics() {
        //no one can create a new object using new.
    }
// JVM does NOT load Holder Why? Because Holder is not actively used yet untill call getInstance
    public static class Holder {
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }

    public static JudgeAnalytics getInstance() {
        return Holder.judgeAnalytics;
    }
}

public class Main {
    public static void main(String[] args) {

        JudgeAnalytics judgeAnalytics1 = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
        System.out.println(judgeAnalytics1);
        System.out.println(judgeAnalytics2);
        System.out.println(JudgeAnalytics.getInstance());

    }
}