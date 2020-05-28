class Main {
  public static void main(String[] args) {
    System.out.println(RecursionMethod.isIdentifier("Hh"));
    System.out.println(RecursionMethod.isPalindrome("HhH"));
    System.out.println(RecursionMethod.isAnBn("HHBB"));
    System.out.println(RecursionMethod.isPre("+pp"));
    System.out.println(RecursionMethod.preToPost("++pp+pp"));
    System.out.println(RecursionMethod.costOfHanoi(10));
  }
}

class RecursionMethod {
  public static String result;
  
  public static int costOfHanoi(int n){
    if(n==1) return 1;
    return costOfHanoi(n-1)+costOfHanoi(1)+costOfHanoi(n-1);
  }
  
  public static String preToPost(String pre) {
    char ch = pre.charAt(0);
    result = pre.substring(1,pre.length());
    if(isLetter(ch)) return ""+ch;
    else {
      String post1 = preToPost(result);
      String post2 = preToPost(result);
      return post1 + post2 + ch;
    }
  }
  
  public static boolean isPre(String pre) {
    int first = 0;
    int last = pre.length()-1;
    // first,last between 0 and pre.length()-1
    int lastIndex = endPre(pre,first,last);
    if(lastIndex==last) return true;
    else return false;
  }
  
  public static int endPre(String pre, int first, int last) {
    if(first>last) return -1;
    if(isLetter(pre.charAt(first))) return first;
    else if(isOper(pre.charAt(first))) {
      int firstEnd = endPre(pre, first+1,last);
      if(firstEnd==-1) return -1;
      else return endPre(pre, firstEnd+1,last);
    } else return -1;
  }
  
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
  
  public static boolean isOper(char ch) {
    if(ch=='+' || ch=='-' ||ch=='*') return true;
    else return false;
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