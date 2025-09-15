package main;

import java.util.Scanner;
import menus.MainMenu;

public class Main {
  public static void main(String[] args) {
    System.out.println("     /////////  //////////  ///////////  ////////////  ///       ///         ///          /// ");
    System.out.println("    ///        ///         ///              ///       ///     ///  ///      //////       /// ");
    System.out.println("   ////////   //////////  //////////       ///       ///    ///     ///    ///   ///    /// ");
    System.out.println("  ///        ///         ///              ///       ///      ///  ///     ///      /// /// ");
    System.out.println(" ///        //////////  //////////       ///       ///         ///       ///          /// ");
    System.out.println("\n=== Mini Enrollment System ===");
    Scanner scan = new Scanner(System.in);
    Display display = new Display(scan);
    MainMenu mainMenu = new MainMenu(display, scan);
    mainMenu.run();
  }
}
