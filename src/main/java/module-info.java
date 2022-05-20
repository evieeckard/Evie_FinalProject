module com.example.javafx_projects {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens rectangle to javafx.fxml;
    exports rectangle;

    opens showhide to javafx.fxml;
    exports showhide;

    opens circle to javafx.fxml;
    exports circle;

    opens texteditor to javafx.fxml;
    exports texteditor;

    opens piggybank to javafx.fxml;
    exports piggybank;

    opens calculator to javafx.fxml;
    exports calculator;

    opens showhide2 to javafx.fxml;
    exports showhide2;

    opens numberGuess to javafx.fxml;
    exports numberGuess;

    opens collegeplan to javafx.fxml;
    exports collegeplan;

    opens restaurantMenu to javafx.fxml;
    exports restaurantMenu;

    opens textNumber to javafx.fxml;
    exports textNumber;

    opens photoAlbum to javafx.fxml;
    exports photoAlbum;

    opens stats to javafx.fxml;
    exports stats;

    opens guesser to javafx.fxml;
    exports guesser;
}