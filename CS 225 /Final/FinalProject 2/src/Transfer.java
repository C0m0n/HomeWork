import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class Transfer extends BorderPane{
    GridPane pane;
    Button transferButton, goBack;
    TextField transferAccount, transferAmmount;
    Label accountLabel, ammountLabel, tooMuchLabel;
    EagleBank bank;
    
    Transfer(EagleBank bank){   
        this.bank = bank;
        pane = new GridPane();
        transferButton = new Button("Transfer");
        goBack = new Button("Go Back");
        transferAccount = new TextField();
        transferAmmount = new TextField();
        accountLabel = new Label("Account to transfer to");
        ammountLabel = new Label("Ammount to be transfered");
        tooMuchLabel = new Label();
        tooMuchLabel.setText("Not enought funds to transfer");
        tooMuchLabel.setTextFill(Paint.valueOf("red"));
        tooMuchLabel.setVisible(false);
        pane.add(accountLabel, 0, 1);
        pane.add(transferButton, 1, 4);
        pane.add(goBack, 1, 2);
        pane.add(transferAccount, 0, 2);
        pane.add(transferAmmount, 0, 4);
        pane.add(ammountLabel, 0, 3);
        pane.add(tooMuchLabel, 2, 4);
        pane.setAlignment(Pos.CENTER);

        this.setCenter(pane);
        goBack.setOnAction((e)-> navigateToMain());
        transferButton.setOnAction((e) -> transferFunds(transferAccount.getText(), transferAmmount.getText()));
    }

    private void transferFunds(String acountNumber, String ammount){
        try{
            Acount transferingAcount = new Acount(Integer.parseInt(bank.acountNumber));
            Acount toTransferAcount = new Acount(Integer.parseInt(acountNumber));

            if (transferingAcount.validWithdrawl(Double.parseDouble(ammount))){
                bank.logger.add("Transfer from "+ bank.acountNumber +" to "+transferAccount.getText()+" ammount " + ammount);
                transferingAcount.withdraw(Double.parseDouble(ammount));
                toTransferAcount.deposit(Double.parseDouble(ammount));
                navigateToMain();
            } else{
                tooMuchLabel.setVisible(true);
            }
            
        } catch (IOException e){
            e.printStackTrace();
        }

       

    }

    public void navigateToMain() {
        fireEvent(new ChangePageEvent(ATMApp.PageName.MAINPAGE));
    }
}
