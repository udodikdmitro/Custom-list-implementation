package package1;

import java.util.Objects;

class NewPassword{
    private static String LOGIN = "someUserName";

    public boolean makePassword(String myPassword){

        if(Objects.equals(myPassword, LOGIN)){
            return false;
        }

        if(!myPassword.matches("[\\da-zA-Zа-яА-Я–!@#$%^&*()_+:;,.-]+")){
            return false;
        }

        String chars = "–!@#$%^&*()_-+:;,.";
        int i = 0;

        char[] charArray = chars.toCharArray();
        char[] passwordCharArray = myPassword.toCharArray();

        for(char ch: charArray){

            for (char chP: passwordCharArray){
                if(chP == ch){
                    i++;
                }
                if(i > 3){
                    return false;
                }
            }
            i = 0;
        }

        return true;
    }
    public static void main(String[] args) {

        NewPassword newPassword = new NewPassword();
        System.out.println(newPassword.makePassword("7655757643cfnhv****c-xnx776"));
    }
}