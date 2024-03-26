package labs.day4.lab1;


class HillStations {
    public void location() {
        System.out.println("Located in the hills.");
    }
    public void famousFor() {
        System.out.println("Famous for its scenic beauty.");
    }
}

class Manali extends HillStations {
    @Override
    public void location() {
        System.out.println("Manali is located in Himachal Pradesh.");
    }

    @Override
    public void famousFor() {
        System.out.println("Manali is famous for Hadimba Temple and adventure sports.");
    }
}

class Mussoorie extends HillStations {
    @Override
    public void location() {
        System.out.println("Mussoorie is located in Uttarakhand.");
    }

    @Override
    public void famousFor() {
        System.out.println("Mussoorie is famous for Kempty Falls and Lal Tibba.");
    }

}

class Gulmarg extends HillStations {
    @Override
    public void location() {
        System.out.println("Gulmarg is located in Jammu and Kashmir.");
    }

    @Override
    public void famousFor() {
        System.out.println("Gulmarg is famous for skiing and Gondola ride.");
    }
}

public class Main {
    public static void main(String[] args) {
        HillStations hillStation = new HillStations();
        hillStation.location();
        hillStation.famousFor();

        System.out.println();

        Manali manali = new Manali();
        manali.location();
        manali.famousFor();

        System.out.println();

        Mussoorie mussoorie = new Mussoorie();
        mussoorie.location();
        mussoorie.famousFor();

        System.out.println();

        Gulmarg gulmarg = new Gulmarg();
        gulmarg.location();
        gulmarg.famousFor();

    }
}