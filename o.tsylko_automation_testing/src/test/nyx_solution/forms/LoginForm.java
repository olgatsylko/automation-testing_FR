/*package nyx_solution.forms;
public class LoginForm extends BaseForm {
    private final TextBox txbLogin = new TextBox(By.id("user_name"), "Username");
    private final TextBox txbPassword = new TextBox(By.id("password"), "Password");
    private final Button btnLogin = new Button(By.xpath("//input[contains(@type, \"submit\")]"), "Log on");

    public LoginForm() {
        super(By.id("user_name"), "login form");
    }

    public void doLogin(final String user, final String pwd) {
        txbLogin.setText(user);
        txbPassword.setText(pwd);
        btnLogin.click();
        browser.waitForPageToLoad();
    }
}*/
