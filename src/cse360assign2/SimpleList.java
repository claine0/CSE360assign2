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
		int[] copylist=new int[list.length];
		if(count<list.length) {
			for(int index=0;index<list.length-1;index++) {
				templist[index+1]=list[index];
			}
			for(int index=1;index<list.length-1;index++) {
				list[index]=templist[index];
			}
			list[0]=add_input;
		}
		else {
			for(int index=0;index<copylist.length;index++) {
				copylist[index]=list[index];
			}
			list=new int[copylist.length+(int) Math.floor(list.length*(1/2.0))];
			for(int index=1;index<copylist.length;index++) {
				list[index]=copylist[index-1];
			}
			list[0]=add_input;
		}
	}
	
	public void remove(int remove_input) {
		int empty_elements=list.length-count;
		int[] copylist=new int[list.length];
		if(search(remove_input)!=-1) {
			for(int index=search(remove_input);index<list.length-1;index++) {
				list[index]=list[index+1];
			}
			count--;
		}
		else {
			System.out.println("not in array");
		}
		if(empty_elements>Math.floor(1/4.0*list.length)&&list.length-empty_elements>1) {
			for(int index=0;index<list.length;index++) {
				copylist[index]=list[index];
			}
			list=new int[list.length-empty_elements];
			for(int index=0;index<list.length;index++) {
				list[index]=copylist[index];
			}
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
	
	public void append(int append_input) {
		count++;
		int[] copylist=new int[list.length];
		if(count<list.length) {
			list[count]=append_input;
		}
		else {
			for(int index=0;index<copylist.length;index++) {
				copylist[index]=list[index];
			}
			list=new int[copylist.length+(int) Math.floor(list.length*(1/2.0))];
			for(int index=0;index<copylist.length;index++) {
				list[index]=copylist[index];
			}
			list[count]=append_input;
		}
	}
	
	public int first() {
		if(count!=0) {
			return list[0];
		}
		else {
			return -1;
		}
	}
	
	public int last() {
		if(count!=0) {
			return list[count];
		}
		else {
			return -1;
		}
	}
	
	public int size() {
		return list.length;
	}
	
}
