package core.handlers;

import configuration.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static services.enums.Emoji.CRYING_FACE;

@Component
public class ChebotariumHandler extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if(update.hasMessage() && update.getMessage().hasText()) {
            if(!sendAnswer(update)) {
                SendMessage message = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("Я испытываю некоторые трудности с ответом " + CRYING_FACE
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
                .setChatId(update.getMessage().getChatId());

        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        switch (checkMsg(update.getMessage().getText())){
            case (-1):
                message.setText("Привет "
                + update.getMessage().getChat().getUserName() + "!\n"
                + "Выбери команду из списка!");

                KeyboardButton keyboardButton = new KeyboardButton();
                keyboardButton.setText("кнопка");

                KeyboardRow keyboardRow = new KeyboardRow();
                keyboardRow.add("Меню");
                keyboardRow.add(keyboardButton);

                keyboardRows.add(keyboardRow);

                break;
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(replyKeyboardMarkup);

//        SendMessage message = new SendMessage()
//                .setChatId()
//                .setText(
//                        "Привет " + update.getMessage().getChat().getUserName() + "\n тебя зовут: "
//                                + update.getMessage().getChat().getFirstName() + " "
//                                + update.getMessage().getChat().getLastName
        try {
            execute(message);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int checkMsg(String msg) {
        if(msg.equals("/start")) {
            return 0;
        }
        else if(msg.equals("/menu")){
            return 1;
        } else if(msg.equals("/basket")){
            return 2;
        }

        return (-1);
    }

}
