import Base.Animal;
import Base.Dog;
import Interface.LeaderOfThePack;
import Interface.Wild;

public class Wolf extends Dog implements Wild, LeaderOfThePack {
    Leader leader;
    String local;
    String date;
    public Wolf(int height, int weight, String colorEye, String colorWool, String local, String date, Leader leader) {
        super(height, weight, colorEye, colorWool);
        setLeaderOfThePack(leader);
        setHabitat(local);
        setLocationDate(date);
    }

    @Override
    public void setHabitat(String local) {
        this.local = local;
    }
    @Override
    public void setLocationDate(String date) {
        this.date = date;
    }
    public void makeSound(Animal animal){
        System.out.println("Woooooo");
    }
    @Override
    public void setLeaderOfThePack(Leader leader) {
        this.leader = leader;
    }
}
