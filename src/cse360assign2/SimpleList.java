package cse360assign2;
/**Chris Laine
 * 131
 * assign1
 * descripition: This class provides the functionality to change and print a simple array list*/
public class SimpleList {
	private int list[];
	private int count;
	
	public SimpleList() {
		list=new int[10];
		count=0;
	}
	
	public void add(int add_input) {
		count++;
		int[] templist=new int[list.length];
			for(int index=0;index<list.length-1;index++) {
				templist[index+1]=list[index];
			}
			for(int index=1;index<list.length-1;index++) {
				list[index]=templist[index];
			}
			list[0]=add_input;
	}
	
	public void remove(int remove_input) {
		if(search(remove_input)!=-1) {
			for(int index=search(remove_input);index<list.length-1;index++) {
				list[index]=list[index+1];
			}
			count--;
		}
		else {
			System.out.println("not in array");
		}
	}
	
	public int count() {
		return count;
	}
	
	public String toString() {
		String array_string="";
		for(int index=0; index<list.length;index++) {
				if(list[index]!=0) {
					array_string+=list[index];
					array_string+=" ";
				}
		}
		return array_string;
	}
	
	public int search(int search_term) {
		int search_index=0;
		int found=0;
		for(int index=0;index<10;index++) {
			if(list[index]==search_term) {
				search_index=index;
				found=1;
			}
		}
		if(found!=1) {
			return -1;
		}
		else {
			return search_index;
		}
	}
}
