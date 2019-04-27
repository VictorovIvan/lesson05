import java.util.*;


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

/**
 * Class CardHomeAnimals
 */
public class CardHomeAnimals extends Animal {
    /**
     * Constructor of card of the animal
     *
     * @param idNumber     Id number of the animal
     * @param nameAnimal   Name of the animal
     * @param ownerAnimal  Owner of the animal
     * @param weightAnimal Weight of the animal
     */
    public CardHomeAnimals(String idNumber, String nameAnimal, Person ownerAnimal, String weightAnimal) {
        super(idNumber, nameAnimal, ownerAnimal, weightAnimal);
    }

    private Integer idNumberAnimalKey = 0;

    private Map<Integer, String> idNumberAnimalsMap = new HashMap<>();
    private Map<Integer, String> nameAnimalsMap = new HashMap<>();
    private Map<Integer, Person> ownerAnimalsMap = new HashMap<>();
    private Map<Integer, String> weightAnimalsMap = new HashMap<>();
    private Map<Integer, String> ownerSortAnimalsMap = new HashMap<>();

    /**
     * Check duplicate of id number in the collection
     *
     * @param newIdNumber Id number of the new animal
     * @return Boolean if is in collection (true) else false
     */
    public boolean checkAddIdNumberAnimal(String newIdNumber) {
        if (idNumberAnimalsMap.containsValue(newIdNumber)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check duplicate of name of animal in the collection
     *
     * @param newName Name of the new animal
     * @return Boolean if is in collection (true) else false
     */
    public boolean checkAddNameAnimal(String newName) {
        if (nameAnimalsMap.containsValue(newName)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check duplicate of owner of animal in the collection
     *
     * @param newOwner Owner of the new animal
     * @return Boolean if is in collection (true) else false
     */
    public boolean checkAddOwnerAnimal(Person newOwner) {
        if (ownerAnimalsMap.containsValue(newOwner)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check duplicate of weight of animal if collection
     *
     * @param newWeight Weight of the new animal
     * @return Boolean if is in collection (true) else false
     */
    public boolean checkAddWeightAnimal(String newWeight) {
        if (weightAnimalsMap.containsValue(newWeight)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add id number new animal in the current collection idNumberAnimalsMap
     *
     * @param newIdNumber New Id number of the animal when will add
     */
    public void addIdNumberAnimal(String newIdNumber) {
        idNumberAnimalsMap.put(idNumberAnimalKey, newIdNumber);
    }

    /**
     * Add new name to new animal in the current collection nameAnimalsMap
     *
     * @param newName New name of the animal when will add
     */
    public void addNameAnimal(String newName) {
        nameAnimalsMap.put(idNumberAnimalKey, newName);
    }

    /**
     * Add owner of animal to new animal in the current collection ownerAnimalsMap
     *
     * @param newOwner New owner of the animal when will add
     */
    public void addOwnerAnimal(Person newOwner) {
        ownerAnimalsMap.put(idNumberAnimalKey, newOwner);
    }

    /**
     * Add weight of new animal in the current collection weightAnimalsMap
     *
     * @param newWeight New weight of the animal when will add
     */
    public void addWeightAnimal(String newWeight) {
        weightAnimalsMap.put(idNumberAnimalKey, newWeight);
    }

    /**
     * Add new animals in the collection
     *
     * @param newAnimal New animal when will add
     */
    public void addNewAnimal(Animal newAnimal) {

        if ((checkAddIdNumberAnimal(newAnimal.idNumber)) && (checkAddNameAnimal(newAnimal.nameAnimal))
                && (checkAddOwnerAnimal(newAnimal.ownerAnimal)) && (checkAddWeightAnimal(newAnimal.weightAnimal))) {
            System.out.println("Дублирующее животное. Запись запрещена");
        } else {
            idNumberAnimalKey++;
            addIdNumberAnimal(newAnimal.idNumber);
            addNameAnimal(newAnimal.nameAnimal);
            addOwnerAnimal(newAnimal.ownerAnimal);
            addWeightAnimal(newAnimal.weightAnimal);
        }
    }

    /**
     * Get key from the collection, using value
     *
     * @param hm    Map collection
     * @param value Search value
     * @return key Key current collection
     */
    public static Integer getKeyFromValue(Map<Integer, String> hm, String value) {
        Integer key = 0;
        for (Map.Entry entry : hm.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = (Integer) entry.getKey();
                break;
            }
        }
        return key;
    }

    /**
     * Search animal using name of the animal
     *
     * @param searchingName searching name of the animal
     * @return searchingAnimal Animal when searched
     */
    public Animal searchToNameAnimal(String searchingName) {
        Animal searchingAnimal = null;
        Integer key = null;

        key = getKeyFromValue(nameAnimalsMap, searchingName);
        searchingAnimal = new Animal(idNumberAnimalsMap.get(key), nameAnimalsMap.get(key), ownerAnimalsMap.get(key), weightAnimalsMap.get(key));
        return searchingAnimal;
    }

    /**
     * Change parameters animal using id identifier of the animal
     *
     * @param identificatAnimalInpt Animal when we will search
     * @param changeAnimal          New change animal
     */
    public void changeCodeWIthIdentificator(String identificatAnimalInpt, Animal changeAnimal) {
        Integer key;
        String identificatAnimal = identificatAnimalInpt;
        key = getKeyFromValue(idNumberAnimalsMap, identificatAnimalInpt);
        nameAnimalsMap.put(key, changeAnimal.nameAnimal);
        ownerAnimalsMap.put(key, changeAnimal.ownerAnimal);
        weightAnimalsMap.put(key, changeAnimal.weightAnimal);
    }

    /**
     * Print to the Display sorted to name animal
     */
    public void printDisplayToSortedNameAnimal() {
        printDisplayToSortedAnimal(nameAnimalsMap);
    }

    /**
     * Print to the Display sorted to owner animal
     */
    public void printDisplayToSortedOwnerAnimal() {
        for (Integer key : ownerAnimalsMap.keySet()) {
            ownerSortAnimalsMap.put(key, ownerAnimalsMap.get(key).nameOwner);
        }
        printDisplayToSortedAnimal(ownerSortAnimalsMap);
    }

    /**
     * Print to the Display sorted to weight animal
     */
    public void printDisplayToSortedWeightAnimal() {
        printDisplayToSortedAnimal(weightAnimalsMap);
    }

    /**
     * Print to the Display sorted animal
     */
    public void printDisplayToSortedAnimal(Map hm) {
        List<String> arraySortingAnimal = new ArrayList<>(hm.values());
        Collections.sort(arraySortingAnimal);
        Iterator ir = arraySortingAnimal.iterator();
        String searchAnimal;
        Integer key;
        while (ir.hasNext()) {
            searchAnimal = ir.next().toString();
            key = getKeyFromValue(hm, searchAnimal);
            System.out.println(nameAnimalsMap.get(key) + " " + idNumberAnimalsMap.get(key) +
                    " " + ownerAnimalsMap.get(key) + " " + weightAnimalsMap.get(key));
        }
    }

    /**
     * Returns a {@code String} object representing this
     * {@code Animal}'s value.
     *
     * @return a string representation of the value of this object in base
     */
    @Override
    public String toString() {
        return "Карта животного{" +
                " Идентификационный номер = " + idNumberAnimalsMap.values() +
                ", Кличка = " + nameAnimalsMap.values() +
                ", Хозяин = " + ownerAnimalsMap.values() +
                ", Вес =" + weightAnimalsMap.values() +
                '}';
    }
}
