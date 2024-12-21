package com.gmail.mpylypenko.homeworks.hw141;

public class PrinterRunner implements Printer {

    @Override
    public void print(Message message) {
        if (this.valueAbsent(message.sender) && this.valueAbsent(message.text)) {
            PrinterRunner anonymousMessage = new PrinterRunner() {
                @Override
                public void print(Message defaultMessage) {
                    System.out.println(defaultMessage.text);
                }
            };
            anonymousMessage.print(new Message("Опрацьовується пусте повідомлення від анонімного користувача..."));
            return;
        }

        if (this.valueAbsent(message.sender)) {
            System.out.println("Анонімний користувач відправив повідомлення: " + message.text);
            return;
        }

        System.out.println("Користувач " + message.sender + " відправив повідомлення: " + message.text);
    }

    private boolean valueAbsent(String value) {
        return value == null || value.isEmpty();
    }

    public static class Message {
        String text;
        String sender;

        public Message() {
        }

        public Message(String text) {
            this.text = text;
        }

        public Message(String sender, String text) {
            this.text = text;
            this.sender = sender;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSender() {
            return this.sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }
}
