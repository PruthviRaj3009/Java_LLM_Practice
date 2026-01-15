interface Recamendation {
    public void recommend();

}

class Resent implements Recamendation{
    @Override
    public void recommend()
    {
        System.out.println("Resent");
    }
}

class oldView implements Recamendation{
    @Override
    public void recommend()
    {
        System.out.println("Ole view");
        
    }
}

class Trending implements Recamendation {
    @Override
    public void recommend() {
        System.out.println("Trending view");

    }
}

class RecamendationAlgo {
    private Recamendation startergy;

    public RecamendationAlgo(Recamendation startergy) {
        this.startergy = startergy;
    }

    public void recomandAlgo() {
        startergy.recommend();
    }
    
}
public class Main{
    public static void main(String[] args) {
        RecamendationAlgo obj1 = new RecamendationAlgo(new oldView());
        obj1.recomandAlgo();
    }
}