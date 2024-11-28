package abstractclassesenums;

abstract class Bird extends Animal implements IConsumable {
    protected String name;

    public Bird(String name) {
        super(AnimalType.Bird);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
