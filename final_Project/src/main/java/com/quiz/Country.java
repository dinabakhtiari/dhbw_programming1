package final_Project.src.main.java.com.quiz;

public class Country {
    private String name;    // Name of the country [cite: 20]
    private String capital; // Correct capital city [cite: 9]

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    // Getters for data security 
    public String getName() { return name; }
    public String getCapital() { return capital; }
}
