import javax.mail.PasswordAuthentication;

public abstract class Authenticator extends Object{
    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }
}
