
import Management.StudentManagement;

/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
/**
 *
 * @author chall
 */
public class Main {

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        while (true) {
            int choice = management.getMenuChoice();

            switch (choice) {
                case 1:
                    management.create();
                    break;
                case 2:
                    management.findAndSort();
                    break;
                case 3:
                    management.updateAndDelete();
                    break;
                case 4:
                    management.report();
                    break;
                case 5:
                    return;
            }
        }
    }
}
