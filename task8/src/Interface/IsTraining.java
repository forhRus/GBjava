package Interface;
import Base.Animal;
public interface IsTraining {

    public enum Training{
        Yes, No;
    }
    public void setTraining(Training training);
    public void training(Animal animal);
}
