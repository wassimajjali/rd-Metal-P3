package parser;

public class Organiser {
	public static int spacecounter(String yas){
		int i=0;
		String[] t = yas.split(" ");
		if(t.length !=0){
		while(i<t.length && t[i].equals("")){
		i++;
		}
		return i+1;
		}else{
			return -1;
			}
	}

}
