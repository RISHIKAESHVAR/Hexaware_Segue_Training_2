package hexaware1;

import java.util.ArrayList;
import java.util.List;

public class passorfail {
	public static void pass_fail(List<Integer>marks,int passmark,List<Integer> passlist,List<Integer> faillist) {
		for (int i : marks) {
			if(i >= passmark) {
				passlist.add(i);
			}else {
				faillist.add(i);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> marks = List.of(4,6,7,88,99,3,45,23,67,89,12,34,56);
		int passmark = 40;
		
		List<Integer> passlist = new ArrayList<>();
		List<Integer> faillist = new ArrayList<>();
		
		pass_fail(marks,passmark,passlist,faillist);
		
		System.out.println("Pass List is :" + passlist);
		System.out.println("Fail List is :" + faillist);
	}

}
