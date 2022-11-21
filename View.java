package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;

public class View {

    Controller control;
    private GridPane StartView;

    // Button and Label are shown on the GUI
    Button exitButton = new Button("Exit");
    Button findShipmentButton = new Button("Show Shipment Info");

    ComboBox<String> fromSelectionComBo = new ComboBox<String>();
    ComboBox<String> toSelectionComBo = new ComboBox<String>();
    //Text for comboboxes
    Label startHabour = new Label("Shows starting habour");
    Label destinationHabour = new Label("Shows destination");
    Label containerAmountInput = new Label("Amount of containers");

    //Textarea Output
    TextArea textArea = new TextArea();
    //Textarea containers input
    TextField textField = new TextField();

    public View(Controller control){
        this.control = control;
        CreateAndConfigure();
    }

    private void CreateAndConfigure() {

        StartView = new GridPane();
        // Editing part of the GUI
        StartView.setMinSize(300, 400);
        StartView.setPadding(new Insets(10, 10, 10, 10));
        StartView.setVgap(5);
        StartView.setHgap(1);
        //Info button

        StartView.add(findShipmentButton, 5,3);
        //Exit button
        StartView.add(exitButton, 19,0);

        //Combobox to og from habour
        StartView.add(toSelectionComBo, 1,3);
        StartView.add(fromSelectionComBo, 1,1);

        //Text for comboboxes
        StartView.add(destinationHabour, 1,2);
        StartView.add(startHabour, 1,0);

        //Text Output area
        StartView.add(textArea,1,7, 20,50);
        //TextField container input
        StartView.add(textField,3,1, 2,2);
        //Text for container input
        StartView.add(containerAmountInput, 3,0);



        //Shows from habour info inside combobox in GUI
        ObservableList<String> habourResults = control.getHabourNames();
        fromSelectionComBo.setItems(habourResults);
        //Same for starting port
        toSelectionComBo.setItems(habourResults);



    }

    public Parent asParent(){
        return StartView;
    }
    }

