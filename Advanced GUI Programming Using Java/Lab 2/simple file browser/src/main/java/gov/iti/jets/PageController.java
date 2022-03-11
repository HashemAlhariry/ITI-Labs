package gov.iti.jets;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class PageController implements Initializable {

    @FXML
    private TreeView treeView;
    @FXML
    private Button fileChooserButton;
    @FXML
    private ListView listView;
    @FXML
    private TextField pathText;


    private HashMap<String,Boolean> checker;

    private static final String ROOT_FOLDER = "/Users/hashemalhariry/Desktop/ITI";

    TreeItem<FilePath> rootTreeItem;
    TreeView<FilePath> treeViewFilePath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        checker = new HashMap<String, Boolean>();
        pathText.setText(ROOT_FOLDER);
        treeViewFilePath = new TreeView<FilePath>();
        fileChooserButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                String path = pathText.getText();
                updatingViews(path);
            }
        });


        EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
            FilePath name = (FilePath) ((TreeItem)treeView.getSelectionModel().getSelectedItem()).getValue();

            if(  Files.isDirectory(name.getPath()))
            {
                updatingListViews(name.getPath().toString());
            }
            System.out.println(name.getPath().toString());
        };

        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);


    }

    public static void createTree(TreeItem<FilePath> rootItem) throws IOException {

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(rootItem.getValue().getPath())) {
            for (Path path : directoryStream) {
                TreeItem<FilePath> newItem = new TreeItem<FilePath>( new FilePath( path));
                newItem.setExpanded(true);
                rootItem.getChildren().add(newItem);
                if (Files.isDirectory(path)) {
                    createTree(newItem);
                }
            }
        }
        catch( Exception ex) {
            ex.printStackTrace();
        }
    }

    void updatingViews(String path){

        rootTreeItem = new TreeItem<FilePath>( new FilePath( Paths.get( path)));
        rootTreeItem.setExpanded(true);
        try {
            createTree(rootTreeItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
        treeView.setRoot(rootTreeItem);
            updatingListViews(path);

    }

    List<String> updatingListViews(String path){

        List<String> foldersNames = new ArrayList<>();
        listView.getItems().clear();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        listView.setEditable(true);

        for (int i = 0; i < listOfFiles.length; i++) {
            listView.getItems().add(listOfFiles[i].getName());
            foldersNames.add(listOfFiles[i].getName());
        }

        return  foldersNames;
    }


}
