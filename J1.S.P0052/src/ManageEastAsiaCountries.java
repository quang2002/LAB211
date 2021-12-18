
import java.util.ArrayList;

/**
 *
 * @author yuyu
 */
public class ManageEastAsiaCountries {

    private ArrayList<EastAsiaCountries> countries;
    private EastAsiaCountries lastCountry;

    public ManageEastAsiaCountries() {
        countries = new ArrayList<>();
        lastCountry = null;
    }

    public void addCountry() {
        Validation vld = new Validation();

        String code, name, terrain;
        float area;

        code = vld.getString("Enter code of country: \n", "[\\w ]+");
        name = vld.getString("Enter name of country: \n", "[\\w ]+");

        while (true) {
            area = vld.getFloat("Enter total Area: \n", 0, Float.MAX_VALUE);
            if (area > 0) {
                break;
            }
            System.err.println("Area must be greater than 0");
        }

        terrain = vld.getString("Enter terrain of country: \n", "[\\w ]+");

        lastCountry = new EastAsiaCountries(terrain, code, name, area);
        countries.add(lastCountry);

        // sort
        countries.sort((EastAsiaCountries c1, EastAsiaCountries c2) -> c1.countryName.compareTo(c2.countryName));
    }

    public void displayHeader() {
        System.out.printf("%10s%20s%20s%10s\n", "ID", "Name", "Total Area", "Terrain");
    }

    public void displayLastCountry() {
        displayHeader();
        lastCountry.display();
    }

    public void displayAllCountries() {
        displayHeader();
        for (EastAsiaCountries country : countries) {
            country.display();
        }
    }

    public void searchCountry() {
        Validation vld = new Validation();
        String countryName = vld.getString("Enter the name you want to search for: \n", "[\\w ]+");

        EastAsiaCountries searchCountry = null;
        for (EastAsiaCountries country : countries) {
            if (country.countryName.equalsIgnoreCase(countryName)) {
                searchCountry = country;
                break;
            }
        }

        if (searchCountry != null) {
            displayHeader();
            searchCountry.display();
        }
        else {
            System.err.println(countryName + "is not existing");
        }
    }
}
