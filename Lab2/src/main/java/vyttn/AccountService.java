package vyttn;

public class AccountService {

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.length() <= 6) return false;
        if (!isValidEmail(email)) return false;
        return true;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    // Phương thức thêm: mô phỏng ghi log thành công đăng ký
    public String generateWelcomeMessage(String username) {
        return "Welcome, " + username + "!";
    }
}
