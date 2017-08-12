package com.homedev.bot;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;

public class Update {

    Integer id;
    Message message;
    Message editedMessage;
    InlineQuery inlineQuery;
    ChosenInlineResult chosenInlineResult;
    CallbackQuery callbackQuery;
}
