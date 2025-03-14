package lab3;

import java.util.*;

class Cinema {
    String name;
    List<Hall> halls;

    Cinema(String name) {
        this.name = name;
        this.halls = new ArrayList<>();
    }

    void addHall(Hall hall) {
        halls.add(hall);
    }
}

class Hall {
    int id;
    int rows;
    int cols;
    Seat[][] seats;

    Hall(int id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.seats = new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    void printSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j].isOccupied ? "X " : "O ");
            }
            System.out.println();
        }
    }
}

class Seat {
    int row;
    int col;
    boolean isOccupied;

    Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.isOccupied = false;
    }
}

class Movie {
    String title;
    int duration;

    Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}

class Session {
    Movie movie;
    Hall hall;
    Date time;

    Session(Movie movie, Hall hall, Date time) {
        this.movie = movie;
        this.hall = hall;
        this.time = time;
    }
}

class Ticket {
    Session session;
    Seat seat;

    Ticket(Session session, Seat seat) {
        this.session = session;
        this.seat = seat;
        this.seat.isOccupied = true;
    }
}

public class TicketSystem {
    static List<Cinema> cinemas = new ArrayList<>();
    static List<Movie> movies = new ArrayList<>();
    static List<Session> sessions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Администратор\n2. Пользователь\n3. Выход");
            int choice = scanner.nextInt();
            if (choice == 1) {
                adminMenu();
            } else if (choice == 2) {
                userMenu();
            } else if (choice == 3) {
                break;
            }
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("1. Добавить кинотеатр\n2. Добавить зал\n3. Добавить фильм\n4. Создать сеанс\n5. Назад");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите название кинотеатра:");
                String name = scanner.next();
                cinemas.add(new Cinema(name));
            } else if (choice == 2) {
                System.out.println("Выберите кинотеатр:");
                for (int i = 0; i < cinemas.size(); i++) {
                    System.out.println((i + 1) + ". " + cinemas.get(i).name);
                }
                int cinemaIndex = scanner.nextInt() - 1;
                System.out.println("Введите количество рядов и мест в ряду:");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                cinemas.get(cinemaIndex).addHall(new Hall(cinemas.get(cinemaIndex).halls.size() + 1, rows, cols));
            } else if (choice == 3) {
                System.out.println("Введите название фильма и длительность (в минутах):");
                String title = scanner.next();
                int duration = scanner.nextInt();
                movies.add(new Movie(title, duration));
            } else if (choice == 4) {
                System.out.println("Выберите фильм:");
                for (int i = 0; i < movies.size(); i++) {
                    System.out.println((i + 1) + ". " + movies.get(i).title);
                }
                int movieIndex = scanner.nextInt() - 1;
                System.out.println("Выберите кинотеатр:");
                for (int i = 0; i < cinemas.size(); i++) {
                    System.out.println((i + 1) + ". " + cinemas.get(i).name);
                }
                int cinemaIndex = scanner.nextInt() - 1;
                System.out.println("Выберите зал:");
                for (int i = 0; i < cinemas.get(cinemaIndex).halls.size(); i++) {
                    System.out.println((i + 1) + ". Зал " + cinemas.get(cinemaIndex).halls.get(i).id);
                }
                int hallIndex = scanner.nextInt() - 1;
                System.out.println("Введите дату и время сеанса (в формате ГГГГ-ММ-ДД ЧЧ:ММ):");
                sessions.add(new Session(movies.get(movieIndex), cinemas.get(cinemaIndex).halls.get(hallIndex), new Date()));
            } else if (choice == 5) {
                break;
            }
        }
    }

    static void userMenu() {
        while (true) {
            System.out.println("1. Поиск сеанса\n2. Купить билет\n3. Назад");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Введите название фильма:");
                String title = scanner.next();
                for (Session session : sessions) {
                    if (session.movie.title.equalsIgnoreCase(title)) {
                        System.out.println("Сеанс: " + session.movie.title + " в " + session.hall.id + " зале, время: " + session.time);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Выберите сеанс:");
                for (int i = 0; i < sessions.size(); i++) {
                    System.out.println((i + 1) + ". " + sessions.get(i).movie.title + " в " + sessions.get(i).hall.id + " зале, время: " + sessions.get(i).time);
                }
                int sessionIndex = scanner.nextInt() - 1;
                Session session = sessions.get(sessionIndex);
                System.out.println("План зала:");
                session.hall.printSeats();
                System.out.println("Выберите ряд и место:");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (!session.hall.seats[row][col].isOccupied) {
                    new Ticket(session, session.hall.seats[row][col]);
                    System.out.println("Билет куплен!");
                } else {
                    System.out.println("Место уже занято!");
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}