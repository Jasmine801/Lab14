package Lab14;

public class Searching {

    public Student LinealSearch(Student[] Arr, int element) {
        for( int i = 0; i < Arr.length; i++) {
            if(Arr[i].getId() == element)
                return Arr[i];
        }
        return null;
    }

    public Student BinarySearch(Student[] Arr, int key, int low, int high) {
        Student index = new Student(-1,0,"");
        index.setId(-1);

        while (low <= high) {
            int mid = (low + high) / 2;
            if (Arr[mid].getId() < key) {
                low = mid + 1;
            } else if (Arr[mid].getId() > key) {
                high = mid - 1;
            } else if (Arr[mid].getId() == key) {
                index = Arr[mid];
                break;
            }
        }
        return index;
    }


}