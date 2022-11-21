package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;


import java.util.ArrayList;
import java.sql.SQLException;

public class Controller {

    Model model;
    View view;

    public Controller(Model model) {
        this.model = model;
        try {
            model.connect();
            model.creatingStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public void settingView(View view) {
        this.view = view;

        EventHandler<ActionEvent> printShippingInformation = e-> printShippingInfo(view.fromSelectionComBo.getValue(), view.toSelectionComBo.getValue(),view.textField.getText(), view.textArea);


        view.findShipmentButton.setOnAction(printShippingInformation);
        view.exitButton.setOnAction(e -> Platform.exit());


    }

    public ObservableList<String> getHabourNames() {
        ArrayList<String> Names = model.habourListNames();
        ObservableList<String> fromHabourNames = FXCollections.observableList(Names);
        return fromHabourNames;
    }

    public void printShippingInfo(String fromport, String toport, String capacityCount, TextArea txtArea ) {
        txtArea.clear();
        model.preparedStatementPrintShippingInfo();
        ArrayList<ShippingData> shipping = model.FindShippingData(fromport, toport, capacityCount);
        for (int i = 0; i < shipping.size(); i++) {
            txtArea.appendText("Starting Port: " + shipping.get(i).fromport + "\n" +
                    "Destination: " + shipping.get(i).toport + "\n" +
                    "Vessel: " + shipping.get(i).vessel + "\n" +
                    "Flow: " + shipping.get(i).flow + "\n" +
                    "Capacity: " + shipping.get(i).capacity + "\n");
            System.out.println();
        }
    }
}
