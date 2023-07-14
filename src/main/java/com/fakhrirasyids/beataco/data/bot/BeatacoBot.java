/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fakhrirasyids.beataco.data.bot;

import com.fakhrirasyids.beataco.data.database.CommandTableHandler;
import com.fakhrirasyids.beataco.data.database.MessageTableHandler;
import com.fakhrirasyids.beataco.data.database.UserTableHandler;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author Fakhri
 */
public class BeatacoBot extends TelegramLongPollingBot {

    private CommandTableHandler commandTableHandler = new CommandTableHandler();
    private UserTableHandler userTableHandler = new UserTableHandler();
    private MessageTableHandler messageTableHandler = new MessageTableHandler();

    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage response = new SendMessage();
        String responseMsg = "";
        Object[][] allCommands = commandTableHandler.getAllCommands();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if (messageTableHandler.addMessage(update.getMessage().getChatId(), update.getMessage().getText(), "masuk")) {
            System.out.println("Successfully save user message to database");
        } else {
            System.out.println("Failed save user message to database");
        }

        if (command.equals("/start")) {
            if (userTableHandler.checkUserId(update.getMessage().getChatId())) {
                responseMsg = "Selamat datang kembali, " + update.getMessage().getFrom().getFirstName() + "!\n\n";
                responseMsg += "Berikut adalah list command yang tersedia:\n";

                for (int i = 0; i < allCommands.length; i++) {
                    responseMsg += "\n" + allCommands[i][1] + " - " + allCommands[i][3];
                }

                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(responseMsg);
            } else {
                responseMsg = "Selamat datang di BeatacoBot!\nUntuk memulai, silahkan /register terlebih dahulu!";
                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(responseMsg);
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/register")) {
            if (userTableHandler.checkUserId(update.getMessage().getChatId())) {
                responseMsg = "Apakah kamu lupa kalau kamu sudah pernah registrasi, " + update.getMessage().getFrom().getFirstName() + "?\n\n";
                responseMsg += "Berikut adalah list command yang tersedia:\n";

                for (int i = 0; i < allCommands.length; i++) {
                    responseMsg += "\n" + allCommands[i][1] + " - " + allCommands[i][3];
                }

                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(responseMsg);
            } else {
                if (userTableHandler.addUser(update.getMessage().getChatId(), update.getMessage().getFrom().getFirstName())) {
                    responseMsg = "Berhasil registrasi. Selamat datang, " + update.getMessage().getFrom().getFirstName() + "!";

                    responseMsg += "\n\nBerikut adalah list command yang tersedia:\n";

                    for (int i = 0; i < allCommands.length; i++) {
                        responseMsg += "\n" + allCommands[i][1] + " - " + allCommands[i][3];
                    }

                    response.setChatId(update.getMessage().getChatId().toString());
                    response.setText(responseMsg);
                } else {
                    responseMsg = "Gagal register!\n\nSilahkan ulang registrasi dengan memasukkan command /register.";
                    response.setChatId(update.getMessage().getChatId().toString());
                    response.setText(responseMsg);
                }
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/unregister")) {
            if (userTableHandler.checkUserId(update.getMessage().getChatId())) {
                if (userTableHandler.deleteUser(update.getMessage().getChatId())) {
                    responseMsg = "Berhasil unregister. Selamat tinggal, " + update.getMessage().getFrom().getFirstName() + "!";
                    response.setChatId(update.getMessage().getChatId().toString());
                    response.setText(responseMsg);
                } else {
                    responseMsg = "Gagal unregister!\n\nSilahkan ulang unregistrasi sekali lagi /unregister.";
                    response.setChatId(update.getMessage().getChatId().toString());
                    response.setText(responseMsg);
                }
            } else {
                responseMsg = "Tak bisa menerima apapun jika belum register!\n\nSilahkan /register terlebih dahulu!";
                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(responseMsg);
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            if (userTableHandler.checkUserId(update.getMessage().getChatId())) {
                for (int i = 0; i < allCommands.length; i++) {
                    if (command.equals(String.valueOf(allCommands[i][1]))) {
                        responseMsg = String.valueOf(allCommands[i][2]);
                        response.setChatId(update.getMessage().getChatId().toString());
                        response.setText(responseMsg);
                        try {
                            execute(response);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    if (i == allCommands.length - 1) {
                        responseMsg = "Command tidak ditemukan!";
                        response.setChatId(update.getMessage().getChatId().toString());
                        response.setText(responseMsg);
                        try {
                            execute(response);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            } else {
                responseMsg = "Tak bisa menerima apapun jika belum register!\n\nSilahkan /register terlebih dahulu!";
                response.setChatId(update.getMessage().getChatId().toString());
                response.setText(responseMsg);
                try {
                    execute(response);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

        if (messageTableHandler.addMessage(update.getMessage().getChatId(), responseMsg, "keluar")) {
            System.out.println("Successfully save bot message to database");
        } else {
            System.out.println("Failed save bot message to database");
        }
    }

    @Override
    public String getBotUsername() {
        return "BeatacoBot";
    }

    @Override
    public String getBotToken() {
        return "API_KEY";
    }

    public void sendMessageExecutor(SendMessage msg) {
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
