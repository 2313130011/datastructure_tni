package ss;


	import java.util.ArrayDeque;
	import java.util.Deque;

	public class Sorting {

		private int[] array;
		
		public Sorting(int[] array) {
			this.array = array;
		}
		
		public int[] getArray() {
			return array;
		}
		
		public void printSortedData() {
			for (int i=0; i<array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
		
		public void bubbleSort() {
			for (int i=0; i<array.length; i++) {
				boolean is_swapped = false;
				for (int j=0; j<array.length-i-1; j++) {
					int current = j;
					if (array[current] > array[current+1]) {
						int temp = array[current];
						array[current] = array[current+1];
						array[current+1] = temp;
						is_swapped = true;
					}
				}
				if (is_swapped == false) {
					break;
				}
			}
		}
		
		public void selectionSort() {
			for (int i=0; i<array.length; i++) {
				int current = i;
				int min_index = i;
				for (int j=current; j<array.length; j++) {
					if (array[j] < array[min_index]) {
						min_index = j;
					}
				}
				int temp = array[current];
				array[current] = array[min_index];
				array[min_index] = temp;
			}
		}
		
		public void insertionSort() {
			for (int i=1; i<array.length; i++) {
				int key = array[i];
				int walker_index = i-1;
				while (walker_index >= 0 && array[walker_index] > key) {
					array[walker_index+1] = array[walker_index];
					walker_index = walker_index-1;
				}
				array[walker_index+1] = key;
			}
		}
		
		public void quickSort() {
			Deque<Integer> stack = new ArrayDeque<Integer>();
			stack.push(array.length-1);
			stack.push(0);
			while (!stack.isEmpty()) {
				int low = stack.pop();
				int high = stack.pop();
				if (high - low < 1) {
					continue;
				}
				int j = partition(low, high);
				stack.push(high);
				stack.push(j+1);
				stack.push(j);
				stack.push(low);
			}
		}
		
		private int partition(int low, int high) {
			int pivot = array[low];
			int i = low, j = high;
			while (true) {
				while (array[i] < pivot) {
					i++;
				}
				while (array[j] > pivot) {
					j--;
				}
				if (i >= j) {
					break;
				}
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
			return j;
		}
		
	}

