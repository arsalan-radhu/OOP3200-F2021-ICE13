module ca.durhamcollege.oop3200f2021ice13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.durhamcollege.oop3200f2021ice13 to javafx.fxml;
    exports ca.durhamcollege.oop3200f2021ice13;
}