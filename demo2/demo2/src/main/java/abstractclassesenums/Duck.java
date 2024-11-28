package abstractclassesenums;

public class Duck extends Bird implements IInsurable {
    public Duck(String name) {
        super(name);
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
        return getName() + ": " + "Delicate";
    }

    @Override
    public String isMainCourseDish() {
        return getName() + ": " + true;
    }
    
}
