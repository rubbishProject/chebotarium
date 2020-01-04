package core;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

//@Component
public class ChebotariumBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if(update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText() + "1");

            try {
                execute(message);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "ChebotariumBot";
    }

    public String getBotToken() {
        return "1021570162:AAH1Bb3SxCWpHaVPYnGarrKFAjogpjEmpFk";
    }
}
