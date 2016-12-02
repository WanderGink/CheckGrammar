package rule;

public class Patterns {
	public Patterns() {};

    // Kiem tra so luong nguyen am
    public boolean checkVowel(String x) {
    	String singleVowel = "aăâeêioôơuưy";
		int count = 0;
		x = x.toLowerCase();
		
		for (int i = 0; i < x.length(); i++) {
			if (singleVowel.contains(String.valueOf(x.charAt(i)))) {
				count++;
			}
		}
		if (count > 0 && count < 4) {
			return true;
		}
		return false;
	}
    
    // Kiem tra a
    public boolean checkA(String x) {
    	x.toLowerCase().trim();
    	String vowelA = "a";
    	String[] nonFirstConsonantA = {"gh", "k", "ngh", "q"};
    	String[] consonantA = {"c", "ch", "i", "m", "n", "ng", "nh", "o", "p", "t", "u", "y"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelA.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('a'));
    			if (sub.equals(nonFirstConsonantA[0]) || sub.equals(nonFirstConsonantA[1])
    					|| sub.equals(nonFirstConsonantA[2]) || sub.equals(nonFirstConsonantA[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('a') + 1, x.length());
    			for (int j = 0; j < consonantA.length; j++) {
    				if (consonantA[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // check ă
    public boolean checkAW(String x) {
    	x.toLowerCase().trim();
    	String vowelAW = "ă";
    	String[] nonFirstConsonantAW = {"gh", "k", "ngh", "q"};
    	String[] consonantAW = {"c", "m", "n", "ng", "p", "t"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelAW.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('ă'));
    			if (sub.equals(nonFirstConsonantAW[0]) || sub.equals(nonFirstConsonantAW[1])
    					|| sub.equals(nonFirstConsonantAW[2]) || sub.equals(nonFirstConsonantAW[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('ă') + 1, x.length());
    			for (int j = 0; j < consonantAW.length; j++) {
    				if (consonantAW[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // check â
    public boolean checkAA(String x) {
    	x.toLowerCase().trim();
    	String vowelAA = "â";
    	String[] nonFirstConsonantAA = {"gh", "k", "ngh", "q"};
    	String[] consonantAA = {"c", "m", "n", "ng", "p", "t", "u", "y"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelAA.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('â'));
    			if (sub.equals(nonFirstConsonantAA[0]) || sub.equals(nonFirstConsonantAA[1])
    					|| sub.equals(nonFirstConsonantAA[2]) || sub.equals(nonFirstConsonantAA[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('â') + 1, x.length());
    			for (int j = 0; j < consonantAA.length; j++) {
    				if (consonantAA[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // Kiem tra e
    public boolean checkE(String x) {
    	x.toLowerCase().trim();
    	String vowelE = "e";
    	String[] nonFirstConsonantE = {"c", "g", "ng", "q"};
    	String[] consonantLastE = {"c", "ch", "m", "n", "ng", "o", "p", "t"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelE.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('e'));
    			if (sub.equals(nonFirstConsonantE[0]) || sub.equals(nonFirstConsonantE[1])
    					|| sub.equals(nonFirstConsonantE[2]) || sub.equals(nonFirstConsonantE[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('e') + 1, x.length());
    			for (int j = 0; j < consonantLastE.length; j++) {
    				if (consonantLastE[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // Check ê
    public boolean checkEE(String x) {
    	x.toLowerCase().trim();
    	String vowelEE = "ê";
    	String[] nonFirstConsonantEE = {"c", "g", "ng", "q"};
    	String[] consonantLastEE = {"ch", "m", "n", "nh", "p", "t", "u"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelEE.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('ê'));
    			if (sub.equals(nonFirstConsonantEE[0]) || sub.equals(nonFirstConsonantEE[1])
    					|| sub.equals(nonFirstConsonantEE[2]) || sub.equals(nonFirstConsonantEE[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('ê') + 1, x.length());
    			for (int j = 0; j < consonantLastEE.length; j++) {
    				if (consonantLastEE[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    // Kiem tra i
    public boolean checkI(String x) {
    	x.toLowerCase().trim();
    	String vowelE = "i";
    	String[] nonFirstConsonantI = {"c","ng", "q", "qu"};
    	String[] consonantLastI = {"a", "êc", "êm", "ên", "êng", "êp", "êu",
    				"êt", "ch", "m", "n", "nh", "p", "t", "u"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelE.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('i'));
    			if (sub.equals(nonFirstConsonantI[0]) || sub.equals(nonFirstConsonantI[1])
    					|| sub.equals(nonFirstConsonantI[2]) || sub.equals(nonFirstConsonantI[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('i') + 1, x.length());
    			for (int j = 0; j < consonantLastI.length; j++) {
    				if (consonantLastI[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // Check o
    public boolean checkO(String x) {
    	x.toLowerCase().trim();
    	String vowelO = "o";
    	String[] nonFirstConsonantO = {"gh", "k", "ngh", "q"};
    	String[] consonantLastO = {"a", "ac", "ăc", "ach", "ai", "am", "ăm", "an", "ăn",
    				"ang", "ăng", "anh", "ao", "ap", "at", "ăt", "ay", "c"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelO.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('o'));
    			if (sub.equals(nonFirstConsonantO[0]) || sub.equals(nonFirstConsonantO[1])
    					|| sub.equals(nonFirstConsonantO[2]) || sub.equals(nonFirstConsonantO[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('o') + 1, x.length());
    			for (int j = 0; j < consonantLastO.length; j++) {
    				if (consonantLastO[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count == 2) {
    			if ("o".equals(x.charAt(i+1))) {
    				return false;
    			} else return true;
    		}
    	}
    	return false;
    }
    
    // Check oo
    public boolean checkOO(String x) {
    	x.toLowerCase().trim();
    	String vowelOO = "ô";
    	String[] nonFirstConsonantOO = {"gh", "k", "ngh", "q"};
    	String[] consonantLastOO = {"c", "i", "m", "n", "ng", "ôc", "ông", "p", "t"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelOO.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('ô'));
    			if (sub.equals(nonFirstConsonantOO[0]) || sub.equals(nonFirstConsonantOO[1])
    					|| sub.equals(nonFirstConsonantOO[2]) || sub.equals(nonFirstConsonantOO[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('ô') + 1, x.length());
    			for (int j = 0; j < consonantLastOO.length; j++) {
    				if (consonantLastOO[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    public boolean checkOW(String x) {
    	x.toLowerCase().trim();
    	String vowelOW = "ơ";
    	String[] nonFirstConsonantOW = {"gh", "k", "ngh", "q"};
    	String[] consonantLastOW = {"c", "i", "m", "n", "ng", "p", "t"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelOW.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('ơ'));
    			if (sub.equals(nonFirstConsonantOW[0]) || sub.equals(nonFirstConsonantOW[1])
    					|| sub.equals(nonFirstConsonantOW[2]) || sub.equals(nonFirstConsonantOW[3])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('ơ') + 1, x.length());
    			for (int j = 0; j < consonantLastOW.length; j++) {
    				if (consonantLastOW[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // check u
    public boolean checkU(String x) {
    	x.toLowerCase().trim();
    	String vowelU = "u";
    	String[] nonFirstConsonantU = {"k", "ngh", "gh"};
    	String[] consonantLastU = {"a", "âc", "âm", "ân", "ât", "ây", "c", "ê",
    				"ên", "ênh", "êt", "i", "m", "n", "ng", "ơ", "ôc", "ôi", "ôm",
    				"ôn", "ông", "ôt", "p", "t", "y", "ya", "ych", "yên", "yêt", "yn",
    				"ynh", "yp", "yu"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelU.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('u'));
    			if (sub.equals(nonFirstConsonantU[0]) || sub.equals(nonFirstConsonantU[1])
    					|| sub.equals(nonFirstConsonantU[2])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('u') + 1, x.length());
    			for (int j = 0; j < consonantLastU.length; j++) {
    				if (consonantLastU[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // check ư
    public boolean checkUW(String x) {
    	x.toLowerCase().trim();
    	String vowelUW = "ư";
    	String[] nonFirstConsonantUW = {"k", "ngh", "gh"};
    	String[] consonantLastUW = {"a", "c", "i", "m", "n", "ng", "ơc", "ơi", "ơm",
    				"ơn", "ơng", "ơp", "ơt", "ơu", "t", "u"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelUW.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('ư'));
    			if (sub.equals(nonFirstConsonantUW[0]) || sub.equals(nonFirstConsonantUW[1])
    					|| sub.equals(nonFirstConsonantUW[2])) {
    				return false;
    			}
    			String last = x.substring(x.indexOf('ư') + 1, x.length());
    			for (int j = 0; j < consonantLastUW.length; j++) {
    				if (consonantLastUW[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    // check y
    public boolean checkY(String x) {
    	x.toLowerCase().trim();
    	String vowelY = "y";
    	String[] firstConsonantY = {"k", "h", "l", "m", "n", "qu", "t", "th", "s", "v"};
    	String[] consonantLastY = {"êm", "ên", "êng", "êt", "êu"};
    	int count = 0;
    	
    	for (int i = 0; i < x.length(); i ++) {
    		if (vowelY.contains(String.valueOf(x.charAt(i)))) {
    			count++;
    		}
    		if (count == 1) {
    			String sub = x.substring(0, x.indexOf('y'));
    			for (int s = 0; s < firstConsonantY.length; s++) {
    				if (!firstConsonantY[i].equals(sub)) {
    					return false;
    				}
    			}
    			String last = x.substring(x.indexOf('y') + 1, x.length());
    			for (int j = 0; j < consonantLastY.length; j++) {
    				if (consonantLastY[j].contains(last)) {
    					return true;
    				}
    			}
    		} else if (count > 2) {
    			return false;
    		}
    	}
    	return false;
    }
    
    public boolean checkVowelTotal(String x) {
    	if (checkVowel(x) || checkA(x) || checkAW(x) || checkAA(x) || checkE(x)
    			|| checkEE(x) || checkI(x) || checkO(x) || checkOO(x) || checkOW(x)
    			|| checkU(x) || checkUW(x) || checkY(x)) {
    		return true;
    	}
    	return false;
    }
}




