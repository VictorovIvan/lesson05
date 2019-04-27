/**
 * Разработать программу – картотеку домашних животных.
 * У каждого животного есть уникальный идентификационный номер, кличка, хозяин
 * (объект класс Person с полями – имя, возраст, пол), вес.
 * <p>
 * Реализовать:
 * <p>
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
 */


/**
 * Class Test
 */
public class Test {
    public static void main(String[] args) {

       CardHomeAnimals animalsCollection = new CardHomeAnimals (null,null,null,null);

        Person ownerAnimalsOne = new Person("Владимир",23, Person.Sex.MAN);
        Person ownerAnimalsTwo = new Person("Влад",23, Person.Sex.MAN);
        Person ownerAnimalsThree = new Person("Алексей",23, Person.Sex.MAN);

        Animal animalsOne = new Animal("5","Лайка",ownerAnimalsOne ,"13.4");


        Animal animalsTwo = new Animal("2","Бобик",ownerAnimalsTwo ,"11.4");
        Animal animalsThree  = new Animal("4","Мурзик",ownerAnimalsThree ,"10.4");

        animalsCollection.addNewAnimal(animalsOne);
        animalsCollection.addNewAnimal(animalsTwo);
        animalsCollection.addNewAnimal(animalsThree);

        System.out.println(animalsCollection.searchToNameAnimal("Бобик").toString());
        animalsCollection.changeCodeWIthIdentificator("2", animalsThree);
        System.out.println(animalsCollection.searchToNameAnimal("Мурзик").toString());

        animalsCollection.printDisplayToSortedNameAnimal();
        animalsCollection.printDisplayToSortedOwnerAnimal();
        animalsCollection.printDisplayToSortedWeightAnimal();

    }
}
