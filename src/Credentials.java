public class Credentials {
//    private static final Object Credentials = Credentials;
    private static String password;
        private static String username;
        private static String host = "pop.gmail.com";
        private static String mailStoreType = "pop3";
        private String email;

        public static String getPassword() {
            return password;
        }

        public static String getUsername() {
            return username;
        }

        public static String getHost() { return host; }

        public static String getMailStoreType() { return mailStoreType; }

        public String getEmail(){ return email;}

        public void setPassword(String password) { this.password = password; }

        public void setUsername(String username) { this.username = username; }

        public void setEmail(String email){ this.email = email; }

        public Object getCredentials(){
            return null;//Credentials;
        }
    }

