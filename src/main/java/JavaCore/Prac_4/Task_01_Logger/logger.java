package JavaCore.Prac_4.Task_01_Logger;

public interface logger {
    public static boolean checkLoginPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login.length() > 20) {
            throw new WrongLoginException();

        }
        if (password.length() > 20 ) {
            throw new WrongPasswordException("Password must be less than 20 characters!");

        }
        else if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Password mismatch!");

        }


        return true;
    }
}