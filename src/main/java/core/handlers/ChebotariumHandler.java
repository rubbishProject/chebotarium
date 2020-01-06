package core.handlers;

import configuration.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static services.enums.Emoji.CRYING_FACE;

@Component
public class ChebotariumHandler extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if(update.hasMessage() && update.getMessage().hasText()) {
            if(sendAnswer(update)) {
                SendMessage message = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("Я испытываю некоторый трудности с ответом " + CRYING_FACE
                                + "\nпопробуйте чуть позже..");
                try {
                    execute(message);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String getBotUsername() {
        return BotConfig.CHEBOTARIUM_USER;
    }

    public String getBotToken() {
        return BotConfig.CHEBOTARIUM_TOKEN;
    }

    public boolean sendAnswer(Update update){
        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(
                        "Привет " + update.getMessage().getChat().getUserName() + "\n тебя зовут: "
                                + update.getMessage().getChat().getFirstName() + " "
                                + update.getMessage().getChat().getLastName()
                );
        try {
            execute(message);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    };

}
