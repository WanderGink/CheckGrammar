package rule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Rules {

	/**
	 * ====================================================================
	 * ======================= QUAN - CHECK VOWEL =====================
	 * ====================================================================
	 */
	
	static int count = 0;
	public HashMap<Integer, String> track;
	public String vowel = "aăâeêioôơuưy";
	public String consonants = "bcdđghklmnpqrstvx";
	public String finalConsonant = "chmngpt";
	public String[] doubleVowel = {
			"ai", "ao", "au", "âu", "ay", "ây",
			"eo", "êu", "ia", "iê", "yê", "iu",
			"oa", "oă", "oe", "oi", "ôi", "ơi",
			"oo", "ôô", "ua", "uă", "uâ", "ưa",
			"uê", "ui", "ưi", "uô", "uơ",
			"ươ", "ưu", "uy"
	};
	public String[] tripleVowel = {
			"iêu", "yêu", "oai", "oao", "oay",
			"oeo", "uao", "uây", "uôi", "ươi",
			"ươu", "uya", "uyê", "uyu"
	};
	
	// Vowel type 1
	public String[] vowelAnyPosition = {"oa", "oe", "uê", "uy"};
	
	// Vowel type 2
	public String[] vowelForceFinalConsonant = {"ă", "oă", "oo", "ôô", "uă", "uyê"};
	
	// Vowel type 3
	public String[] vowelForceFinalLetter = {"â", "iê", "uâ", "uô", "ươ", "yê"};
	
	public Rules() {
		
	}
	
	/**
	 * Loai bo dau trong tieng viet
	 * @param alias
	 * @return string without accent
	 */
	public static String removeAccent(String alias )
	{
	    String str = alias;
	    str = str.toLowerCase(); 
	    str = str.replaceAll("[àáạảã]", "a");
	    str = str.replaceAll("[ằắặẳẵ]", "ă");
	    str = str.replaceAll("[ầấậẩẫ]", "â");
	    str = str.replaceAll("[èéẹẻẽ]", "e");
	    str = str.replaceAll("[ềếệểễ]", "ê");
	    str = str.replaceAll("[ìíịỉĩ]", "i"); 
	    str = str.replaceAll("[òóọỏõ]", "o"); 
	    str = str.replaceAll("[ồốộổỗ]", "ô");
	    str = str.replaceAll("[ờớợởỡ]", "ơ");
	    str = str.replaceAll("[ùúụủũ]", "u");
	    str = str.replaceAll("[ừứựửữ]", "ư");
	    str = str.replaceAll("[ỳýỵỷỹ]", "y");
	    return str;
	}
	
	/**
	 * Kiem tra xem tu x co nguyen am khong
	 * @param x
	 * @return integer
	 */
	public int checkVowel(String x) {
		int count = 0;
		x = x.toLowerCase();
		
		for (int i = 0; i < x.length(); i++) {
			if (vowel.contains(String.valueOf(x.charAt(i)))) {
				count++;
			}
		}
		if (count > 0) {
			return count;
		}
		return 0;
	}
	
	/**
	 * Kiem tra xem tu x co nguyen am doi hop le khong
	 * @param x
	 * @return
	 */
	public HashMap<Integer, String> checkDoubleTripleVowel(String x) {
		x = removeAccent(x);
		track = new HashMap<>();
		int vowelNum = checkVowel(x);
		
		if (vowelNum == 2) {
			for (int i = 0; i < doubleVowel.length; i++) {
				if (x.contains(doubleVowel[i])) {
					track.put(Integer.valueOf(i), doubleVowel[i]);
					break;
				}
			}
			return track;
		}
		
		if (vowelNum == 3) {
			for (int i = 0; i < tripleVowel.length; i++) {
				if (x.contains(tripleVowel[i])) {
					track.put(Integer.valueOf(i), tripleVowel[i]);
					break;
				}
			}
			return track;
		}
		
		if (vowelNum == 1) {
			for (int i = 0; i < x.length(); i++) {
				if (vowel.contains(String.valueOf(x.charAt(i)))) {
					track.put(Integer.valueOf(i), String.valueOf(x.charAt(i)));
					break;
				}
			}
			return track; 
		}
		return null;
	}
	
	/**
	 * Kiem tra nguyen am bat buoc co phu am o cuoi
	 * @param x
	 * @return
	 */
	public boolean checkVowelFinalConsonant(String x) {
		x = removeAccent(x);
		HashMap<Integer, String> mVowel = checkDoubleTripleVowel(x);
		
		if (mVowel != null && mVowel.size() > 0) {
			Set<Entry<Integer, String>> mapSet = mVowel.entrySet();
			Iterator<Entry<Integer, String>> mapIterator = mapSet.iterator();
			
			while (mapIterator.hasNext()) {
				Entry<Integer, String> mapEntry = mapIterator.next();
				
				int start;
				int size = mapEntry.getValue().length() - 1;
				
				// Kiem tra vowel type
				if (checkVowelType(mapEntry.getValue()) == 1) {
					
					for (start = mapEntry.getKey() + size; start < x.length(); start++) {
						if (finalConsonant.contains(String.valueOf(x.charAt(start)))) {
							return true;
						}
					}
				} else return true;
			}
		}
		return false;
	}
	
	/**
	 * Kiem tra sau nguyen am bat buoc phai co nguyen am hay phu am
	 * @param x
	 * @return
	 */
	public boolean checkVowelForceFinalLetter(String x) {
		x = removeAccent(x);
		HashMap<Integer, String> mVowel = checkDoubleTripleVowel(x);
		
		if (mVowel != null && mVowel.size() > 0) {
			Set<Entry<Integer, String>> mapSet = mVowel.entrySet();
			Iterator<Entry<Integer, String>> mapIterator = mapSet.iterator();
			
			while (mapIterator.hasNext()) {
				Entry<Integer, String> mapEntry = mapIterator.next();
				
				int start;
				int size = mapEntry.getValue().length() - 1;
				
				// Kiem tra vowel type
				if (checkVowelType(mapEntry.getValue()) == 2) {
	
					for (start = mapEntry.getKey() + size; start < x.length(); start++) {
						if (finalConsonant.contains(String.valueOf(x.charAt(start)))
								|| vowel.contains(String.valueOf(x.charAt(start)))) {
							return true;
						}
					}
				} else return true;
			}
		}
		return false;
	}
	
	/**
	 * Kiem tra xem x thuoc loai nguyen am nao
	 * @param x
	 * @return
	 */
	public int checkVowelType(String x) {
		try {
			for (int i = 0;; i++) {
				
				if (i < vowelForceFinalConsonant.length && 
						vowelForceFinalConsonant[i] == x) {
					return 1;
				}
				
				if (i < vowelForceFinalLetter.length &&
						vowelForceFinalLetter[i] == x) {
					return 2;
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
			return 0;
		}
	}
	
	
	/**
	 * ====================================================================
	 * ======================= TOAN - CHECK CONSONANT =====================
	 * ====================================================================
	 */
	
	
	// tu tieng viet sai neu co ky tu dac biet
	public boolean checkInvalid0(String x) {
		x.toLowerCase();
		String kiTuDacBiet = "0123456789fwjz~`!@#$%^&*()-_=+[{}]|;:'<>?/";
		for (int i = 0; i < x.length(); i++) {
			if (kiTuDacBiet.contains(String.valueOf(x.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	public boolean checkInvalid1(String x) {
		x.toLowerCase();
		if (x.length() > 7) {
			return true;
		} else
			return false;
	}

	
	// nhung phu am chi co the dung dau
	public boolean checkInvalid6(String x) {
		x.toLowerCase();
		String phuAmDau = "qsdklxvb";
		for (int i = 1; i < x.length(); i++) {
			if (phuAmDau.contains(String.valueOf(x.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	/* check phu am */
	// khong cho phep 3 phu am canh nhau tru ngh

	public boolean checkInvalid7(String x) {
		if (x.length() > 3) {
			for (int i = 0; i < x.length() - 2; i++) {
				if (consonants.contains(String.valueOf(x.charAt(i))) && (consonants.contains(String.valueOf(x.charAt(i + 1))))
						&& consonants.contains(String.valueOf(x.charAt(i + 2))) && ((x.charAt(i) != 'n')
						|| x.charAt(i + 1) != 'g' || x.charAt(i + 2) != 'h')) {
					return true;
				}
			}
		}
		return false;
	}

	// check h
	public boolean checkH(String x) {
		x.toLowerCase();
		String apterH = "ngckt";
		if (x.contains("h")) {
			// if(!x.contains("h"))
			// return true;
			if ((x.charAt(x.length() - 1) == 'h' && ((x.charAt(x.length() - 2) != 'n')
					|| (x.charAt(x.length() - 2) != 'c') || ((x.charAt(1) == 'h')))
					&& (!apterH.contains(String.valueOf(x.charAt(0)))))
					|| (x.length() > 3 && (x.charAt(2) == 'h') && (x.charAt(0) != 'n') && (x.charAt(1) != 'g'))
					|| (x.charAt(0) == 'h' && consonants.contains(String.valueOf(x.charAt(1))))) {
				return false;
			}
		}
		return true;
	}

	// check p
	public boolean checkP(String x) {
		String nguyenAm = "áạặắấậéẹếệíịóọốộớợúụứự";
		x = x.toLowerCase();
		// if(!x.contains("p"))
		// return true;
		if(x.contains("p")){
		if (x.charAt(x.length() - 1) == 'p' && !(nguyenAm.contains(String.valueOf(x.charAt(x.length() - 2))))) {
			return false;
		}
		if (x.charAt(0) == 'p' && x.charAt(1) != 'h') {
			return false;
		}
		}
		return true;
	}
	
	
	//check c
	public boolean checkC(String x){
		String tempC=consonants;
		String nguyenAmSau = "iíìịỉĩeéèẹẻẽêếềệểễ";
		String nguyenAmTruoc = "áạặắấậéẹếệíịóọốộớợúụứự";
		if(x.contains("c")){
			if(x.charAt(0)=='c'&&(nguyenAmSau.contains(String.valueOf(x.charAt(1)))
					||tempC.replace('h', 'c').contains(String.valueOf(x.charAt(1))))){
				return false;
			}
			if (x.charAt(x.length() - 1) == 'c' && !(nguyenAmTruoc.contains(String.valueOf(x.charAt(x.length() - 2))))) {
				return false;
			}
			return true;
		}
		
		return true;
	}
	//check q
	public boolean checkQ(String x){
		if(x.length()>2&&x.contains("q")){
			if(x.charAt(0)=='q'){
				if(x.charAt(1)!='u'){
					return false;
				}else if(consonants.contains(String.valueOf(x.charAt(2)))){
					return false;
				}	
			}
			 return true;
		}
		return true;
	}

	//check r
	public boolean checkR(String x){
		if(x.contains("r")){
			if(x.charAt(0)=='r'){
				if(consonants.contains(String.valueOf(x.charAt(1)))){
					return false;
				}else return true;
			}else if(x.charAt(1)=='r'){
				if(x.charAt(0)!='t'){
					return false;
				}else return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public boolean checkT(String x) {
		String nguyenAm = "áạặấậéẹíịóọốộớợúụ";
		String temp = consonants;
		x.toLowerCase();
		if (x.contains("t")) {
			if (x.charAt(0) == 't' && temp.replace('h', 't').replace('r', 't').contains(String.valueOf(x.charAt(1)))) {
				return false;
			} else if (x.charAt(x.length() - 1) == 't'
					&& !(nguyenAm.contains(String.valueOf(x.charAt(x.length() - 2))))) {
				return false;
			} else
				return true;
		}
		return true;
	}

	public boolean checkN(String x) {
		x = x.toLowerCase();
		String temp = consonants;
		if (x.contains("n")) {
			if (x.charAt(0) != 'n' && x.charAt(x.length() - 1) != 'n' && x.charAt(x.length() - 2) != 'n') {
				return false;
			}
			if (x.charAt(x.length() - 1) == 'n' && consonants.contains(String.valueOf(x.charAt(x.length() - 2)))) {
				return false;
			} else if ((x.charAt(0) == 'n' && (x.charAt(1) != 'g' && x.charAt(1) != 'h'
					&& temp.replace('g', 'n').replace('h', 'n').contains(String.valueOf(x.charAt(1)))))) {
				return false;
			} else if ((x.charAt(x.length() - 2) == 'n'
					&& (x.charAt(x.length() - 1) != 'g' && x.charAt(x.length() - 1) != 'h'
							&& temp.replace('g', 'n').replace('h', 'n').contains(String.valueOf(x.charAt(1)))))) {
				return false;
			} else
				return true;

		}
		return true;
	}

	// check k

	public boolean checkK(String x) {
		String nguyenam = "iíìịỉĩeéèẹẻẽêếềệểễ";
		x.toLowerCase();
		if (x.contains("k")) {
			if (x.charAt(0) == 'k' && (x.charAt(1) == 'h' || nguyenam.contains(String.valueOf(x.charAt(1)))))
				return true;
			else {
				return false;
			}
		}
		return true;
	}

	// check g
	public boolean checkG(String x) {
		String nguyenam = "iíìịỉĩeéèẹẻẽêếềệểễ";
		x.toLowerCase();
		String tempG = consonants;
		if (x.contains("g")) {
			if (x.charAt(0) == 'g') {
				if (x.charAt(1) == 'h' && x.length() > 2) {
					if (nguyenam.contains(String.valueOf(x.charAt(2))))
						return true;
					else {
						return false;
					}
				} else if (tempG.replace('h', 'g').contains(String.valueOf(x.charAt(1)))) {
					return false;
				} else
					return true;
			}
			else if(x.charAt(x.length()-1)=='g'){
				if(x.charAt(x.length()-2)!='n'){
				return false;
			}
			else 
				return true;
			}
		}

		return true;
	}

	//check s
	
	public boolean checkS(String x){
		if(x.contains("s")){
			if(x.charAt(0)=='s'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	//kiem tra x
	public boolean checkX(String x){
		if(x.contains("x")){
			if(x.charAt(0)=='x'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	//kiem tra m
	public boolean checkM(String x){
		if(x.contains("m")){
			if(x.charAt(0)=='m'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else if(x.charAt(x.length()-1)=='m'){
				if(!consonants.contains(String.valueOf(x.length()-2)))
					return true;
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	//kiem tra b
	
	public boolean checkB(String x){
		if(x.contains("b")){
			if(x.charAt(0)=='b'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	
	//check D
	public boolean checkD(String x){
		if(x.contains("d")){
			if(x.charAt(0)=='d'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	
	//check D
	public boolean checkĐ(String x){
		if(x.contains("đ")){
			if(x.charAt(0)=='đ'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	//check L
	public boolean checkL(String x){
		if(x.contains("l")){
			if(x.charAt(0)=='l'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	//check V
	public boolean checkV(String x){
		if(x.contains("v")){
			if(x.charAt(0)=='v'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean check(String x) {
		x = x.trim();
		if (checkInvalid0(x) || checkInvalid1(x) || checkInvalid6(x) || checkInvalid7(x) ||
				(!checkS(x))||(!checkX(x))||(!checkD(x))||(!checkĐ(x))||(!checkL(x))||(!checkV(x))||
				(!checkB(x))||(!checkM(x))||(!checkQ(x))||(!checkR(x))||(!checkC(x))||(!checkH(x))||
				(!checkP(x))|| (!checkT(x)) || (!checkN(x))||(!checkG(x))||(!checkK(x)))
			return false;
		if (checkVowelFinalConsonant(x) || checkVowelForceFinalLetter(x))
			return true;
		return true;
	}
	}


