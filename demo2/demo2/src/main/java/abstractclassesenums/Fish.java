package abstractclassesenums;

public class Fish extends Animal implements IInsurable, IConsumable {
    String name;

    public Fish(String name) {
        super(AnimalType.Fish);
        this.name = name;
    }

    @Override
    public String Expires() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPremium() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String describeTaste() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String isMainCourseDish() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
