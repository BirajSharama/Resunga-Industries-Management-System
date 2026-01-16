package Model;

import java.io.*;
import java.util.*;

public class UserFileDAO {

    private static final String FILE = "users.txt";

    public static List<User> loadUsers() {
        List<User> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new User(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        d[3]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
