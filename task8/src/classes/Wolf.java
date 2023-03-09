package classes;

import Base.Animal;
import Base.Dog;
import Interface.LeaderOfThePack;
import Interface.Wild;

public class Wolf extends Dog implements Wild, LeaderOfThePack {
    Leader leader;
    String local;
    String date;
    public Wolf(double height, double weight, String colorEye, String colorWool, String local, String date, Leader leader) {
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
    @Override
    public void setLeaderOfThePack(Leader leader) {
        this.leader = leader;
    }
    public String getInfo() {
        return String.format("Волк.\n%s, Вожак: %s", super.getInfo(), this.leader);
    }
    public void makeSound(){
        System.out.println("Волк: Woooooo");
    }
}
