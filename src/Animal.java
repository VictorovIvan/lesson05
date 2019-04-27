/**
 * <p>Разработать программу – картотеку домашних животных.
 * У каждого животного есть уникальный идентификационный номер, кличка, хозяин
 * (объект класс Person с полями – имя, возраст, пол), вес.</p>
 * <p>Реализовать:</p>
 * <p>метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.</p>
 */
public class Animal {
    String idNumber;
    String nameAnimal;
    Person ownerAnimal;
    String weightAnimal;

    /**
     * Constructor of animal
     * @param idNumber Id number of animal
     * @param nameAnimal Name of animal
     * @param ownerAnimal Owner of animal
     * @param weightAnimal Weight of animal
     */
    public Animal(String idNumber, String nameAnimal, Person ownerAnimal, String weightAnimal) {
        this.idNumber = idNumber;
        this.nameAnimal = nameAnimal;
        this.ownerAnimal = ownerAnimal;
        this.weightAnimal = weightAnimal;
    }

    /**
     * Returns a {@code String} object representing this value.
     * @return a string representation of the value of this object in base
     */
    @Override
    public String toString() {
        return "Животное{" +
                "Идентификационный номер = " + idNumber +
                ", Имя = '" + nameAnimal + '\'' +
                ", Хозяин = " + ownerAnimal.toString() +
                ", Вес = " + weightAnimal +
                '}';
    }
}