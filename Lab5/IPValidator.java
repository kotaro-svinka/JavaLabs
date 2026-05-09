import java.util.regex.*;
public class IPValidator {
    public static void main(String[] args) {
        String[] testIPs = {
                "192.168.1.1",
                "0.0.0.0",
                "255.255.255.255",
                "127.0.0.1",
                "1.2.3.4",
                "0.1.2.3",
                "255.0.255.0",

                "256.1.1.1",
                "192.168.1",
                "192.168.1.1.1",
                "01.1.1.1",
                "192.168.01.1",
                "192.168.1.256",
                "abc.def.ghi.jkl",
                "192.168..1",
                ".1.2.3",
                "192.168.1.",
                "999.999.999.999",
                "1.2.3.4.5",
                "1.2.3",
                ""
        };

        for (String ip : testIPs) {
            boolean isValid = isValidIP(ip);
            String status = isValid ? "КОРРЕКТНЫЙ" : "НЕ КОРРЕКТНЫЙ";
            System.out.println(ip + " → " + status);
        }
    }


    public static boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        try {
            String octet = "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)";
            String regex = "^" + octet + "\\." + octet + "\\." + octet + "\\." + octet + "$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);

            return matcher.matches();

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getMessage());
            return false;
        }
    }
}
