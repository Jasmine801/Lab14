package Lab14;

public class Sorting {

    public void QuickSort(Student[] Arr, int low, int high) {
        if (Arr.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        Student opora = Arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (Arr[i].getGpa() > opora.getGpa()) {
                i++;
            }

            while (Arr[j].getGpa() < opora.getGpa()) {
                j--;
            }
            if (i <= j) {
                Student temp = Arr[i];
                Arr[i] = Arr[j];
                Arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            QuickSort(Arr, low, j);
        if (high > i)
            QuickSort(Arr, i, high);
    }

    public void MergeSort(Student[] Arr, int a, int b) {
        if (a < b) {
            int m = (a + b) / 2;
            MergeSort(Arr, a, m);
            MergeSort(Arr, m + 1, b);
            Merge(Arr, a, m, b);
        }
    }

    public void Merge(Student[] Arr, int a, int b, int c) {
        int s1 = b - a + 1;
        int s2 = c - b;

        Student[] ch1 = new Student[s1];
        Student[] ch2 = new Student[s2];

        for (int i = 0; i < s1; ++i)
            ch1[i] = Arr[a + i];
        for (int j = 0; j < s2; ++j)
            ch2[j] = Arr[b + 1 + j];

        int i = 0, j = 0;

        int k = a;
        while (i < s1 && j < s2) {
            if (ch1[i].getGpa() >= ch2[j].getGpa()) {
                Arr[k] = ch1[i];
                i++;
            }
            else {
                Arr[k] = ch2[j];
                j++;
            }
            k++;
        }
        while (i < s1) {
            Arr[k] = ch1[i];
            i++;
            k++;
        }
        while (j < s2) {
            Arr[k] = ch2[j];
            j++;
            k++;
        }
    }
}