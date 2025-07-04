package CESAE_Resort;


import CESAE_Resort.Views.LoginView;
import java.io.IOException;

import static CESAE_Resort.Tools.FileUpdate.updateFiles;

public class Main {
    public static void main(String[] args) throws IOException {
        LoginView lv = new LoginView();
        lv.mainMenu();
        updateFiles();
    }
}
