package core.handlers;

import configuration.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ChebotariumHandler extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if(update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(getAnswer(update));

            try {
                execute(message);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return BotConfig.CHEBOTARIUM_USER;
    }

    public String getBotToken() {
        return BotConfig.CHEBOTARIUM_TOKEN;
    }

    public String getAnswer(Update update){
        return "Привет " + update.getMessage().getChat().getUserName() + "\n тебя зовут: "
                + update.getMessage().getChat().getFirstName() + " "
                + update.getMessage().getChat().getLastName();
    };

}
