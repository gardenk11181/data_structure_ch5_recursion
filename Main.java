class Main {
  public static void main(String[] args) {
    System.out.println(RecursionMethod.isIdentifier("Hh"));
    System.out.println(RecursionMethod.isPalindrome("HhH"));
    System.out.println(RecursionMethod.isAnBn("HHBB"));
  }
}

class RecursionMethod {
  
  public static boolean isAnBn(String string) {
    if(string.length()==0) {
      return true;
    } else if(string.length()==1) {
      return false;
    } else {
      return isAnBn(string.substring(1,string.length()-1),string.charAt(0), string.charAt(string.length()-1));
    }
  }
  
  public static boolean isAnBn(String string, char a, char b) {
    if(string.length()==0) {
      return true;
    } else if(string.length()==1) {
      return false;
    } else {
      if(string.charAt(0)==a && string.charAt(string.length()-1)==b) {
        return isAnBn(string.substring(1,string.length()-1), a,b);
      } else {
        return false;
      }
    }
  }
  
  
  public static boolean isIdentifier(String string) {
    if(string.length()==1) {
      if(isLetter(string.charAt(0))) return true;
      else return false;
    } else {
      char lastLetter = string.charAt(string.length()-1);
      if(isLetter(lastLetter) || isDigit(lastLetter)) {
        return isIdentifier(string.substring(0,string.length()-1));
      } else {
        return false;
      }
    }
  } 
  
  public static boolean isLetter(char ch) {
    if(ch>='A' && ch<='z') return true;
    else return false;
  }
  
  public static boolean isDigit(char ch) {
    if(ch>=0 && ch <= '9') return true;
    else return false;
  }
  
  public static boolean isPalindrome(String string) {
    if(string.length()==0 || string.length()==1) {
      return true; 
      
    } else if(string.charAt(0)==string.charAt(string.length()-1)) {
      return isPalindrome(string.substring(1,string.length()-1));
    } else {
      return false;
    }
  }
}