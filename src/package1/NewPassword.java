package package1;

import java.util.Objects;

class NewPassword{
    private static String LOGIN = "someUserName";

    public boolean makePassword(String myPassword){

        if (Objects.equals(myPassword, LOGIN)){
            return false;
        }

        if (!myPassword.matches("[\\da-zA-Zа-яА-Я–!@#$%^&*()_+:;,.-]+")){
            return false;
        }

        for (int i = 0; i < myPassword.length() - 3; i++) {
            if (myPassword.charAt(i) == myPassword.charAt(i + 1)
                    && myPassword.charAt(i) == myPassword.charAt(i + 2)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        NewPassword newPassword = new NewPassword();
        System.out.println(newPassword.makePassword("7655757643cfnhv**c-xnx776"));
    }
}