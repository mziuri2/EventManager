package ge.mziuri.eventmanager.networking;

import ge.mziuri.eventmanager.dao.EventDAO;
import ge.mziuri.eventmanager.dao.EventDAOImpl;
import ge.mziuri.eventmanager.dao.PlaceDAO;
import ge.mziuri.eventmanager.dao.PlaceDAOImpl;
import ge.mziuri.eventmanager.dao.UserDAO;
import ge.mziuri.eventmanager.dao.UserDAOImpl;
import ge.mziuri.eventmanager.model.Place;
import ge.mziuri.eventmanager.model.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Client {

    static DataInputStream in = null;
    static DataOutputStream out = null;
    static Socket socket = null;

    public static void main(String[] args) throws SQLException, ParseException {
        User user1 = new User(3, "tato", "tato123");
        EventDAO eventDAO = new EventDAOImpl();
        PlaceDAO placeDAO = new PlaceDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        System.out.println("შეიყვანეთ მომხარებლის სახელი");
        Scanner s1 = new Scanner(System.in);
        String username = s1.nextLine();
        System.out.println("1)ყველა ივენთის ჩამონათვალი   2)ჩემი შექმნილი ივენთების შამონათვალი");
        System.out.println("3)წასასვლელი ივენთების ჩამონათვალი   4)ივენთების დღევანდელი Top სამეული");
        System.out.println("5)ივენთზე წასვლა   6)ყველა იენთის ადგილების ჩამონათვალი");
        System.out.println("7)ივენთის ძებნა თარიღით და სახელით  პროგრამიდან გამოსასვლელად აკრიფეთ exit");
        Scanner s2 = new Scanner(System.in);
        int choice1 = s2.nextInt();
        switch (choice1) {
            case 1:
                choice1 = 1;
                eventDAO.getAllEvents();
            case 2:
                choice1 = 2;
                userDAO.getMyCreatedEventsDESC();
            case 3:
                choice1 = 3;
                userDAO.getMyGoingEvents(user1);
            case 4:
                choice1 = 4;
                eventDAO.getTodaysTop3Events();
            case 5:
                choice1 = 5;
                eventDAO.getAllEvents();
                break;
            case 6:
                choice1 = 6;
                placeDAO.getAllPlaces();
            case 7:
                choice1 = 7;
                System.out.println("შეიყვანეთ თარიღი ფორმატით წელი-თვე-დღე:");
                Scanner s3 = new Scanner(System.in);
                String dateSTR = s3.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
                Date date = null;
                date = (Date) dateFormat.parse(dateSTR);
                System.out.println("შეიყვანეთ ადგილის სახელი:");
                String placeName=s3.nextLine();
                System.out.println("შეიყვანეთ ადგილის მისამართი:");
                String placeAddress=s3.nextLine();
                Place place=new Place(placeName,placeAddress);
                placeDAO.getEventByDateAndPlace(date, place);

                try {
                    socket = new Socket("localhost", 8659);
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    Scanner scanner = new Scanner(System.in);
                    Thread thread = new Thread() {

                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    String msg = in.readUTF();
                                }
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    };
                    thread.start();
                    while (scanner.hasNextLine()) {
                        out.writeUTF(username);
                        out.writeInt(choice1);
                        String text = scanner.nextLine();
                        out.writeUTF(text);
                        if (text.equals("exit")) {
                            break;
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

        }

    }
}
