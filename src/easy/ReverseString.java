package easy;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("abcdef"));
        assert reverse("Geeks")== "skeeG";
    }

    private static String reverse(String input){
        char reverseArray[] = input.toCharArray();
        for(int i=0;i<input.length()/2;i++){
            char temp = reverseArray[i];
            reverseArray[i]=reverseArray[input.length()-1-i];
            reverseArray[input.length()-1-i]= temp;
        }
        return String.valueOf(reverseArray);
    }
}
