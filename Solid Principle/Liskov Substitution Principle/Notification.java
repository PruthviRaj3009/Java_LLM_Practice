class Notify {
    public void sendnotify() {
        System.out.println("Text message");
    }
}

class whatsNotify extends Notify {
    @Override
    public void sendnotify() {
        System.out.println("Whats App Text message");
    }
}
class EmailNotify extends Notify {
    @Override
    public void sendnotify() {
        System.out.println("Email Text message");
    }
}
public class Notification{
    public static void main(String[] args) {
        Notify obj1 = new EmailNotify();
        obj1.sendnotify();
    }
}