package com.gmail.mpylypenko.homeworks.hw141;

public class ConsolePrinter implements Printer {

    @Override
    public void print(Message message) {
        if (message.invalidMessage()) {
            ConsolePrinter anonymousMessage = new ConsolePrinter() {
                @Override
                public void print(Message defaultMessage) {
                    System.out.println("-=MESSAGE WITHOUT SENDER AND TEXT=-");
                    defaultMessage.setDefaultText();
                    System.out.println(defaultMessage.getText());
                }
            };
            anonymousMessage.print(new Message());
            return;
        }

        if (message.noSender()) {
            System.out.println("Анонімний користувач відправив повідомлення: " + message.getText());
            return;
        }
        System.out.println("-=VALID MESSAGE=-");
        System.out.println("Користувач " + message.sender + " відправив повідомлення: " + message.getText());
    }

    public static class Message {
        private String text;
        private String sender;

        public Message() {

        }

        public Message(String sender, String text) {
            this.text = text;
            this.sender = sender;
        }

        public boolean noSender() {
            return this.getSender() == null || this.getSender().isEmpty();
        }

        public boolean invalidMessage() {
            return (this.getText() == null || this.getText().isEmpty()) && (this.getSender() == null || this.getSender().isEmpty());
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setDefaultText() {
            this.text = "Опрацьовується пусте повідомлення від анонімного користувача...";
        }

        public String getSender() {
            return this.sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }
    }
}
