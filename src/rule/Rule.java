package rule;

public class Rule {
	String vowel = "aăâeêioôơuưyàáãạằắẵặầấậẫèéẽẹềếễệìíĩịòóõọồốỗộờớỡợùúũụừứữựỳýỹỵ";
    // Bo thanh dau trong tieng viet
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
    
//    public boolean checkDoubleConsonant(String s) {
//    	String[] doubleConsonantA = {"ch", "gi", "kh", "ng", "nh", "ph", "qu", "th", "tr"};
//    	for (int i = 0; i < doubleConsonantA.length; i++) {
//    		if (s.equals(doubleConsonantA[i])) {
//    			return true;
//    		}
//    	}
//    	return false;
//    }
    public boolean checkVowel(String x) {
    	x = x.toLowerCase().trim();
    	x = removeAccent(x);
    	String mVowel = "aăâeêioôơuưy";
    	int count = 0;
    	for (int i = 0; i < x.length(); i++) {
    		if (mVowel.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    	}
    	if (count > 0 && count < 4)
    		return true;
    	return false;
    }
    // Kiem tra a
    public boolean checkA(String x) {
    	x = x.toLowerCase().trim();
    	String vowelA = "aáàạã";
    	String[] specialConsonant = {"gi", "qu"};
    	String[] nonFirstConsonantA = {"gh", "k", "ngh", "q"};
    	String[] rhymeA = {"c", "ch", "i", "m", "n", "ng", "nh", "o", "p", "t", "u", "y"};
    	String[] nonRhyme1 = {"c", "ch", "p", "t"}; 	// for a, à, ã
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelA.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
    		// cat phu am dau
			String sub = x.substring(0, x.indexOf(temp));
			
			// check phu am dau
			if (sub.equals(nonFirstConsonantA[0]) || sub.equals(nonFirstConsonantA[1])
					|| sub.equals(nonFirstConsonantA[2]) || sub.equals(nonFirstConsonantA[3])) {
				return false;
			} else if (sub.equals(specialConsonant[0]) || sub.equals(specialConsonant[1])) {
				return true;
			}
			
			// cat phan cuoi sau nguyen am a
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
			
			// check last is empty
			if (!last.equals("")) {
				
				// check rhyme special
				if (temp.equals("a") || temp.equals("à") || temp.equals("ã")) {
					if (nonRhyme1[0].equals(last) || nonRhyme1[1].equals(last) ||
							nonRhyme1[2].equals(last) || nonRhyme1[3].equals(last)) {
						return false;
					}
				}
				
				// duyet rhyme sau a
				for (int j = 0; j < rhymeA.length; j++) {
					if (rhymeA[j].equals(last)) {
						return true;
					}
				}
				
				// sau khi duyet khong co
				return false;
			} else return true;
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // check ă
    public boolean checkAW(String x) {
    	x = x.toLowerCase().trim();
    	String vowelAW = "ăắặẵ";
    	String[] nonFirstConsonantAW = {"gh", "k", "ngh", "q"};
    	String[] specialConsonant = {"gi", "qu"};
    	String[] rhymeAW = {"c", "m", "n", "ng", "p", "t"};
    	String[] nonRhyme1 = {"c", "p", "t"};	// for ă ằ ẵ
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelAW.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantAW[0]) || sub.equals(nonFirstConsonantAW[1])
					|| sub.equals(nonFirstConsonantAW[2]) || sub.equals(nonFirstConsonantAW[3])) {
				return false;
			} else if (sub.equals(specialConsonant[0]) || sub.equals(specialConsonant[1])) {
				return true;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
			
			if (!last.equals("")) {
				
				// check phu am gi, qu
				if (specialConsonant[0].equals(sub) || specialConsonant[1].equals(sub)) {
					return true;
				}
				
				// check non rhyme
				if (temp.equals("ă") || temp.equals("ẵ") || temp.equals("ằ")) {
					if (nonRhyme1[0].equals(last) || nonRhyme1[1].equals(last) ||
							nonRhyme1[2].equals(last)) {
						return false;
					}
				}
				for (int j = 0; j < rhymeAW.length; j++) {
					if (rhymeAW[j].equals(last)) {
						return true;
					}
				}
				return false;
			} else {
				// check phu am gi, qu
				if (specialConsonant[0].equals(sub) || specialConsonant[1].equals(sub)) {
					return false;
				}
				return true;
			}
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // check â
    public boolean checkAA(String x) {
    	x = x.toLowerCase().trim();
    	String vowelAA = "âấậầẫ";
    	String[] nonFirstConsonantAA = {"gh", "k", "ngh", "q"};
    	String[] rhymeAA = {"c", "m", "n", "ng", "p", "t", "u", "y"};
    	String[] nonRhyme1 = {"c", "p", "t"}; // for â ầ ẫ
    	String[] specialConsonant = {"gi", "qu"};
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelAA.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			
			if (sub.equals(nonFirstConsonantAA[0]) || sub.equals(nonFirstConsonantAA[1])
					|| sub.equals(nonFirstConsonantAA[2]) || sub.equals(nonFirstConsonantAA[3])) {
				return false;
			} else if (sub.equals(specialConsonant[0]) || sub.equals(specialConsonant[1])) {
				return true;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
			
			if (!last.equals("")) {
				
				if (temp.equals("â") || temp.equals("ẫ") || temp.equals("ầ")) {
					if (nonRhyme1[0].equals(last) || nonRhyme1[1].equals(last) ||
							nonRhyme1[2].equals(last)) {
						return false;
					}
				}
				
				for (int j = 0; j < rhymeAA.length; j++) {
					if (rhymeAA[j].equals(last)) {
						return true;
					}
				}
				return false;
			} else 
				return true;
			
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // Kiem tra e
    public boolean checkE(String x) {
    	x = x.toLowerCase().trim();
    	String vowelE = "eèéẹẽ";
    	String[] nonFirstConsonantE = {"c", "g", "ng", "q"};
    	String[] rhymeE = {"c", "m", "n", "ng", "o", "p", "t"};
    	String[] rhymeE1 = {"c", "p", "t"}; // for e è ẽ
    	String[] rhymeE2 = {"c"}; // for ẹ
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelE.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantE[0]) || sub.equals(nonFirstConsonantE[1])
					|| sub.equals(nonFirstConsonantE[2]) || sub.equals(nonFirstConsonantE[3])) {
				return false;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}		

			if (!last.equals("")) {
				
				if (temp.equals("ẹ")) {
					if (rhymeE2[0].equals(last)) {
						return false;
					}
				}
				
				if (temp.equals("e") || temp.equals("è") || temp.equals("ẽ")) {
					if (rhymeE1[0].equals(last) || rhymeE1[1].equals(last) ||
							rhymeE1[2].equals(last)) {
						return false;
					}
				}
				
				for (int j = 0; j < rhymeE.length; j++) {
					if (rhymeE[j].equals(last)) {
						return true;
					}
				}
				return false;
			} else {
				return true;
			}
			
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // Check ê
    public boolean checkEE(String x) {
    	x = x.toLowerCase().trim();
    	String vowelEE = "êềệếễ";
    	
    	String[] nonFirstConsonantEE = {"c", "g", "ng", "q"};
    	String[] rhymeEE = {"ch", "m", "n", "nh", "p", "t", "u"};
    	String[] rhymeEE1 = {"ch", "p", "t"};	// for ê ề ễ
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelEE.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
    		
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantEE[0]) || sub.equals(nonFirstConsonantEE[1])
					|| sub.equals(nonFirstConsonantEE[2]) || sub.equals(nonFirstConsonantEE[3])) {
				return false;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
			
			if (!last.equals("")) {
				if (temp.equals("ê") || temp.equals("ề") || temp.equals("ễ")) {
					if (rhymeEE1[0].equals(last) || rhymeEE1[1].equals(last) ||
							rhymeEE1[2].equals(last)) {
						return false;
					}
				}
				for (int j = 0; j < rhymeEE.length; j++) {
					if (rhymeEE[j].equals(last)) {
						return true;
					}	
				}
				return false;
			} else
				return true;
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    // Kiem tra i
    public boolean checkI(String x) {
    	x = x.toLowerCase().trim();
    	String vowelE = "iíịìĩ";
    	String vowel = "aăâeêioôơuưy";
    	String[] nonFirstConsonantI = {"c","ng", "q", "qu"};
    	String[] rhymeI = {"a", "êc", "êm", "ên", "êng", "êp", "êu",
    				"êt", "ch", "m", "n", "nh", "p", "t", "u"};
    	// for i
    	String[] rhymeI1 = {"êc", "êp", "êt", "ch", "p", "t"};
    	// for í ị
    	String[] rhymeI2 = {"êc", "êm", "ên", "êng", "êp", "êu", "êt"};
    	// for ì ĩ 
    	String[] rhymeI3 = {"êc", "êm", "ên", "êng", "êp", "êu", "êt", "p", "t" };
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelE.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantI[0]) || sub.equals(nonFirstConsonantI[1])
					|| sub.equals(nonFirstConsonantI[2]) || sub.equals(nonFirstConsonantI[3])) {
				return false;
			}
			
			// neu la phu am gi thi tra ve true
			if (sub.equals("g")) {
				return true;
			}
			// rhyme after i
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			
			// remove accent last for non i
			String rLast = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}

			if (!last.equals("")) {
				if (temp.equals("i")) {
					for (int i = 0; i < rhymeI1.length; i++) {
						if (rhymeI1[i].equals(last)) {
							return false;
						}
					}
				}
				if (temp.equals("í") || temp.equals("ị")) {
					for (int i = 0; i < rhymeI2.length; i++) {
						if (rhymeI2[i].equals(rLast)) {
							return false;
						}
					}
				}
				if (temp.equals("ì") || temp.equals("ĩ")) {
					for (int i = 0; i < rhymeI3.length; i++) {
						if (rhymeI3[i].equals(rLast)) {
							return false;
						}
					}
				}
				for (int j = 0; j < rhymeI.length; j++) {
					if (rhymeI[j].equals(rLast)) {
						return true;
					}
				}
				return false;
			} else
				return true;
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // Check o
    public boolean checkO(String x) {
    	x = x.toLowerCase().trim();
    	String vowelO = "oóọòõ";
    	String[] nonFirstConsonantO = {"gh", "k", "ngh", "q"};
    	String[] consonantLastO = {"a", "ac", "ăc", "ach", "ai", "am", "ăm", "an", "ăn",
    				"ang", "ăng", "anh", "ao", "ap", "at", "ăt", "ay", "c", "e", "em",
    				"en", "eng", "eo", "et", "i", "m", "n", "ng", "oc", "ong", "p", "t"};
    	
    	// for o
    	String[] rhymeO1 = {"c", "p", "t"};
    	// for ó ọ
    	String[] rhymeO2 = {"ac", "ăc", "ach", "ai", "am", "ăm", "an", "ăn", "ang", "ăng", 
    				"anh", "ao", "ap", "at", "ăt", "ay", "em", "en", "eng", "eo", "et", "oc",
    				"ong"};
    	
    	// for ò õ
    	String[] rhymeO3 = {"ac", "ăc", "ach", "ai", "am", "ăm", "an", "ăn", "ang", "ăng", 
				"anh", "ao", "ap", "at", "ăt", "ay", "em", "en", "eng", "eo", "et", "oc",
				"ong", "c", "p", "t"};
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelO.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantO[0]) || sub.equals(nonFirstConsonantO[1])
					|| sub.equals(nonFirstConsonantO[2]) || sub.equals(nonFirstConsonantO[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
			
			if (!last.equals("")) {
				
				if (temp.equals("o")) {
					for (int i = 0; i < rhymeO1.length; i++) {
						if (rhymeO1[i].equals(last)) {
							return false;
						}
					}
				}
				if (temp.equals("ó") || temp.equals("ọ")) {
					for (int i = 0; i < rhymeO2.length; i++) {
						if (rhymeO2[i].equals(last)) {
							return false;
						}
					}
				}
				if (temp.equals("ò") || temp.equals("õ")) {
					for (int i = 0; i < rhymeO3.length; i++) {
						if (rhymeO3[i].equals(last)) {
							return false;
						}
					}
				}
				for (int j = 0; j < consonantLastO.length; j++) {
					if (consonantLastO[j].equals(last)) {
						return true;
					}
				}
				return false;
			} else
				return true;
		} else if (count == 2) {
			if ("o".equals(x.charAt(x.indexOf('o') + 1))) {
				return false;
			} else return true;
		}
    	return true;
    }
    
    // Check oo
    public boolean checkOO(String x) {
    	x = x.toLowerCase().trim();
    	String vowelOO = "ôồốỗộ";
    	
    	String[] nonFirstConsonantOO = {"gh", "k", "ngh", "q"};
    	String[] rhymeOO = {"c", "i", "m", "n", "ng", "ôc", "ông", "p", "t"};
    	// for ô
    	String[] rhymeOO1 = {"c", "ôc", "p", "t"};
    	// for ồ ỗ
    	String[] rhymeOO2 = {"c", "ôc", "ông", "p", "t"};
    	// for ố ộ
    	String[] rhymeOO3 = {"ôc", "ông"};
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelOO.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantOO[0]) || sub.equals(nonFirstConsonantOO[1])
					|| sub.equals(nonFirstConsonantOO[2]) || sub.equals(nonFirstConsonantOO[3])) {
				return false;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			String rlast = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
						
			if (!last.equals("")) {
				if (temp.equals("ô")) {
					if (rhymeOO1[0].equals(last) || rhymeOO1[1].equals(last) ||
							rhymeOO1[2].equals(last) || rhymeOO1[3].equals(last)) {
						return false;
					}
				}
				if (temp.equals("ồ") || temp.equals("ỗ")) {
					if (rhymeOO2[0].equals(rlast) || rhymeOO2[1].equals(rlast) ||
							rhymeOO2[2].equals(rlast) || rhymeOO2[3].equals(rlast) ||
							rhymeOO2[4].equals(rlast)) {
						return false;
					}
				}
				if (temp.equals("ố") || temp.equals("ộ")) {
					if (rhymeOO3[0].equals(rlast) || rhymeOO3[1].equals(rlast)) {
						return false;
					}
				}
				for (int j = 0; j < rhymeOO.length; j++) {
					if (rhymeOO[j].equals(rlast)) {
						return true;
					}
				}
				return false;
			} else
				return true;
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    public boolean checkOW(String x) {
    	x = x.toLowerCase().trim();
    	String vowelOW = "ơớờợỡ";
    	String[] nonFirstConsonantOW = {"gh", "k", "ngh", "q"};
    	String[] rhymeOW = {"c", "i", "m", "n", "ng", "p", "t"};
    	// for ơ ờ ỡ
    	String[] rhymeOW1 = {"c", "p", "t"};
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelOW.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantOW[0]) || sub.equals(nonFirstConsonantOW[1])
					|| sub.equals(nonFirstConsonantOW[2]) || sub.equals(nonFirstConsonantOW[3])) {
				return false;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			String rlast = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
						
			if (!last.equals("")) {
				if (temp.equals("ơ")) {
					if (rhymeOW1[0].equals(last) || rhymeOW1[1].equals(last) ||
							rhymeOW1[2].equals(last)) {
						return false;
					}
				}
				if (temp.equals("ờ") || temp.equals("ỡ")) {
					if (rhymeOW1[0].equals(rlast) || rhymeOW1[1].equals(rlast) ||
							rhymeOW1[2].equals(rlast)) {
						return false;
					}
				}
				for (int j = 0; j < rhymeOW.length; j++) {
					if (rhymeOW[j].equals(rlast)) {
						return true;
					}
				}
				return false;
			} else 
				return true;
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // check u
    public boolean checkU(String x) {
    	x = x.toLowerCase().trim();
    	String vowelU = "uúùũụ";
    	
    	String[] nonFirstConsonantU = {"k", "ngh", "gh"};
    	String[] rhymeU = {"a", "âc", "âm", "ân", "ât", "ây", "c", "ê",
    				"ên", "ênh", "êt", "i", "m", "n", "ng", "ơ", "ôc", "ôi", "ôm",
    				"ôn", "ông", "ôt", "p", "t", "y", "ya", "ych", "yên", "yêt", "yn",
    				"ynh", "yp", "yu", "yt", "êch"};
    	// for u
    	String[] rhymeU1 = {"âc", "ât", "ây", "c", "êt", "ôc", "ôt", "p", "t",
    				"ych", "yêt", "yp", "yt", "êch"};
    	// for ù ũ
    	String[] rhymeU2 = {"âc", "âm", "ân", "ât", "ây", "c", "ê", "ên", "ênh", "êt", "ơ",
    				"ôc", "ôi", "ôm", "ôn", "ông", "ôt", "p", "t", "ya", "ych", "yên", "yêt", 
    				"yn", "ynh", "yp", "yu", "yt", "êch", "âng"};
    	// for ú ụ
    	String[] rhymeU3 = {"âc", "âm", "ân", "ât", "ây","ê", "ên", "ênh", "êt", "ơ",
				"ôc", "ôi", "ôm", "ôn", "ông", "ôt", "ya", "ych", "yên", "yêt", 
				"yn", "ynh", "yp", "yu", "yt", "êch", "âng"};
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelU.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}    		
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			
			if (sub.equals("q")) {
				return true;
			}
			if (sub.equals(nonFirstConsonantU[0]) || sub.equals(nonFirstConsonantU[1])
					|| sub.equals(nonFirstConsonantU[2])) {
				return false;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			String rlast = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
						
			if (!last.equals("")) {
				if (temp.equals("u")) {
					for (int i = 0; i < rhymeU1.length; i++) {
						if (rhymeU1[i].equals(last)) {
							return false;
						}
					}
				}
				if (temp.equals("ù") || temp.equals("ũ")) {
					for (int i = 0; i < rhymeU2.length; i++) {
						if (rhymeU2[i].equals(rlast)) {
							return false;
						}
					}
				}
				if (temp.equals("ú") || temp.equals("ụ")) {
					for (int i = 0; i < rhymeU3.length; i++) {
						if (rhymeU3[i].equals(rlast)) {
							return false;
						}
					}
				}
				for (int j = 0; j < rhymeU.length; j++) {
					if (rhymeU[j].equals(rlast)) {
						return true;
					}
				}
				return false;
			} else {
				if (!temp.equals("u")) {
					if (sub.equals("q")) {
						return false;
					}
				}
				return true;
			}
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // check ư
    public boolean checkUW(String x) {
    	x = x.toLowerCase().trim();
    	String vowelUW = "ưứừựữ";
    	
    	String[] nonFirstConsonantUW = {"k", "ngh", "gh", "q"};
    	String[] rhymeUW = {"a", "c", "i", "m", "n", "ng", "ơc", "ơi", "ơm",
    				"ơn", "ơng", "ơp", "ơt", "ơu", "t", "u"};
    	// for ư
    	String[] rhymeUW1 = {"c", "ơc", "ơp", "ơt", "t"};
    	// for ừ ữ
    	String[] rhymeUW2 = {"c", "ơc", "ơi", "ơm", "ơn", "ơng", "ơp", "ơt", "ơu", "t"};
    	// for ứ ự
    	String[] rhymeUW3 = {"ơc", "ơi", "ơm", "ơn", "ơng", "ơp", "ơt", "ơu"};
    	
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelUW.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantUW[0]) || sub.equals(nonFirstConsonantUW[1])
					|| sub.equals(nonFirstConsonantUW[2]) || sub.equals(nonFirstConsonantUW[3])) {
				return false;
			}
			
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			String rlast = removeAccent(last);
			
			// neu co mot nguyen am khac thi k check
			if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
				return true;
			}
						
			if (!last.equals("")) {
				if (temp.equals("ư")) {
					for (int i = 0; i < rhymeUW1.length; i++) {
						if (rhymeUW1[i].equals(last)) {
							return false;
						}
					}
				}
				if (temp.equals("ừ") || temp.equals("ữ")) {
					for (int i = 0; i < rhymeUW2.length; i++) {
						if (rhymeUW2[i].equals(rlast)) {
							return false;
						}
					}
				}
				if (temp.equals("ứ") || temp.equals("ự")) {
					for (int i = 0; i < rhymeUW3.length; i++) {
						if (rhymeUW3[i].equals(rlast)) {
							return false;
						}
					}
				}
				for (int j = 0; j < rhymeUW.length; j++) {
					if (rhymeUW[j].equals(rlast)) {
						return true;
					}
				}
				return false;
			} else
				return true;
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    // check y
    public boolean checkY(String x) {
    	x = x.toLowerCase().trim();
    	String vowelY = "yýỳỵỹ";
    	String[] firstConsonantY = {"k", "h", "l", "m", "n", "t", "th", "s", "v"};
    	String[] consonantLastY = {"êm", "ên", "êng", "êt", "êu"};
    	int count = 0;
    	String temp = "";
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelY.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    			temp = String.valueOf(x.charAt(i));
    		}
    	}
    	
    	if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			
			// kiem tra xem truoc y co phu am
			if (sub.equals("")) {
				if (!last.equals("")) {
					for (int j = 0; j < consonantLastY.length; j++) {
						if (consonantLastY[j].equals(last)) {
							return true;
						}
					}
					return false;
				} else 
					return true;
			} else {
				// neu co mot nguyen am khac thi k check
				if (sub.length() - 1 >= 0 && vowel.contains(String.valueOf(sub.charAt(sub.length() - 1)))) {
					return true;
				}
				
				if (last.equals("")) {
					for (int i = 0; i < firstConsonantY.length; i++) {
						if (firstConsonantY.equals(sub)) {
							return true;
						}
					}
					return false;
				}
			}
		} else if (count > 2) {
			return false;
		}
    	return true;
    }
    
    public boolean checkVowelTotal(String x) {
    	if (!checkVowel(x)) {
    		return false;
    	}
    	if (!checkA(x) || !checkAW(x) || !checkAA(x) || !checkE(x)
    			|| !checkEE(x) || !checkI(x) || !checkO(x) || !checkOO(x) || !checkOW(x)
    			|| !checkU(x) || !checkUW(x)) {
    		return false;
    	}
    	return true;
    }
}




