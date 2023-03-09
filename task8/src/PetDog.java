import Base.Animal;
import Base.Dog;
import Interface.*;

public class PetDog extends Dog implements IsTraining {
    Training training;
    public PetDog(int height, int weight, String colorEye, String colorWool, Training training) {
        super(height, weight, colorEye, colorWool);
        setTraining(training);
    }

    @Override
    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public void training(Animal animal) {
        if(animal instanceof IsTraining) {
            this.training = Training.Yes;
        }
    }
}
