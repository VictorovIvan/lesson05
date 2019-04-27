/**
 * Class person
 */
public class Person {
    enum Sex{MAN,WOMAN};

    String nameOwner;
    Integer AgeOwner;
    Sex sexOwner;


    /**
     * Constructor of owner
     * @param nameOwner Name of owner
     * @param ageOwner Age of owner
     * @param sexOwner Sex of owner
     */
    public Person(String nameOwner, Integer ageOwner, Sex sexOwner) {
        this.nameOwner = nameOwner;
        AgeOwner = ageOwner;
        this.sexOwner = sexOwner;
    }

    /**
     * Returns a {@code String} object representing this
     * {@code String}'s value.
     * @return a string representation of the value of this object in base
     */
    @Override
    public String toString() {
        return " {" +
                "Имя = '" + nameOwner + '\'' +
                ", Возраст = " + AgeOwner +
                ", Пол = " + sexOwner +
                '}';
    }
}
