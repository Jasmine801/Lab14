package Lab14;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

    Student[] Arr = new Student[5];
    String[] stds = {"Федор", "Эмиль", "Данила", "Игорь", "Олег"};
    Student temp = null;
    String name, id, gpa;

    public Test() {
        for(int i = 0; i < 5; i++)
            Arr[i] = new Student((int) (Math.random() * 100), Math.round((Math.random()*5)*100)/100D, stds[i]);
        SearchID(Arr[2].getId());
        SortGpa();
    }

    public void Print1(long time) {
        name = id = gpa = "";
        for(int i = 0; i < 5; i++) {
            name += "Студент: "+Arr[i].getName()+"\t";
            id += "ID: "+Arr[i].getId()+"\t\t\t";
            gpa += "Ср. балл: "+Arr[i].getGpa()+"\t";
        }
        System.out.println(name+"\n"+id+"\n"+gpa+"\n");
        System.out.println("Время сортировки: "+time+" нс\n");
    }

    public void Print2(Student student, long time) {
        System.out.println("Search student with ID "+student.getId()+"");
        name = id = gpa = "";
        name += "Студент: "+student.getName()+"\t";
        id += "id: "+student.getId()+"\t\t\t";
        gpa += "Ср. балл: "+student.getGpa()+"\t";
        System.out.println(name+"\n"+id+"\n"+gpa+"\n"+"Время поиска: "+time+" нс\n");
    }

    private void SearchID(int element) {
        Searching search = new Searching();

        long start = System.nanoTime();
        temp = search.BinarySearch(Arr, element, 0, Arr.length-1);
        long finish = System.nanoTime();
        System.out.println("\nСложность алгоритма Бинарного поиска: O(log n) \nВремя: O(log n)");
        Print2(temp, finish-start);

        SortID();
        start = System.nanoTime();
        temp = search.LinealSearch(Arr, element);
        finish = System.nanoTime();
        System.out.println("Сложность алгоритма Линейного поиска: O(n) \nВремя: O(n)");
        Print2(temp, finish-start);
    }

    private void SortGpa() {
        Sorting sort = new Sorting();
        System.out.println("\n\nСписок студентнов отсортированный по среднему баллу");

        long start = System.nanoTime();
        sort.QuickSort(Arr, 0, Arr.length-1);
        long finish = System.nanoTime();
        System.out.println("Сложность алгоритма быстрой сортировки: O(n log n) \nВремя: O(n log n)");
        Print1(finish-start);

        start = System.nanoTime();
        sort.MergeSort(Arr, 0, Arr.length-1);
        finish = System.nanoTime();
        System.out.println("Сложность алгоритма сортировки слиянием: O(n) \nВремя: O(n log n)");
        Print1(finish-start);
    }

    private void SortID() {

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() > o2.getId() ? 1 : -1;
            }
        };
        Arrays.sort(Arr, comparator);
    }

    public static void main(String[] args) {
        Test ch1 = new Test();
    }
}