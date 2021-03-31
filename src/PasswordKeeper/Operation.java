package PasswordKeeper;

import PasswordKeeper.operations.Add;
import PasswordKeeper.operations.Delete;
import PasswordKeeper.operations.Get;
import PasswordKeeper.operations.Update;

public class Operation {
    public static void execute(){
        boolean k = true;
        while (k) {
            ConsoleHelper.writeMessage(String.format("--------------------%nChoose operation:%n1 - Add%n2 - Get%n3 - Update%n4 - Delete%n5 - Exit"));
            String s = ConsoleHelper.readMessage();
            if (s != null) {
                switch (s) {
                    case "1":
                        Add.add();
                        continue;
                    case "2":
                        Get.get();
                        continue;
                    case "3":
                        Update.updatePassword();
                        continue;
                    case "4":
                        Delete.delete();
                        continue;
                    case "5":
                        ConsoleHelper.writeMessage("--------------------");
                        ConsoleHelper.writeMessage("Bye!");
                        k = false;
                }
            }
        }
    }
}
