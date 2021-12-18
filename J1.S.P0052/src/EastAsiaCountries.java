
/**
 *
 * @author yuyu
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%10s", countryTerrain);
    }
}
