package lab02;

public class RegistrationPlateFactory {
    private static String[] regPlates = { "MRB1G", "RU16", "TOYS4US", "HNZ57", "PUT3", "JB007" };

    private static int currentIndex = 0;

    public static RegistrationPlate getNexRegistrationPlate() {
        if (currentIndex < regPlates.length) {
            String regPlate = regPlates[currentIndex];
            currentIndex++;
            return new RegistrationPlate(regPlate, " | Manchester", " | England", " | 2024");
        } else {
            // Reset index if all plates have been used
            // currentIndex = 0;
            // String regPlate = regPlates[currentIndex];
            // currentIndex++;
            // return new RegistrationPlate(regPlate, "City", "Country", "Year");
            throw new ArrayIndexOutOfBoundsException("*** You need to Create new plates babes ***");
        }
    }
}
