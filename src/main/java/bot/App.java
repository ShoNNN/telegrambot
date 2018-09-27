package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class App extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        // We check if the update has message and the message has text

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(message_text);
            try {
                execute(message);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }

//            Message msg = update.getMessage(); // Это нам понадобится
//            String txt = msg.getText();
//            if (txt.equals("/start")) {
//                sendMsg(msg, "Hello, world! This is simple bot!");
//            }
        }
    }

    public void onUpdatesReceived (List < Update > updates) {


    }

    public String getBotUsername () {
        return "TheVladbot";
    }

    public String getBotToken () {
        return "580139465:AAHkBhEAxrQ2BJ5H-oulRNBNxNsdkRfWpQ8";
    }

    public String getClientName (String clientName){
        //Message msg = update.getMessage();
        //String clientName = msg.getText();
        return clientName;
    }

//    @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
//    private void sendMsg (Message msg, String text){
//        SendMessage s = new SendMessage();
//        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
//        s.setText(text);
//        try { //Чтобы не крашнулась программа при вылете Exception
//            sendMessage(s);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }

}
