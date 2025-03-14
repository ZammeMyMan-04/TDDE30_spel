package main;

import java.awt.*;
import java.util.ArrayList;

import static utilz.Constants.Fonts.ARIAL_10;
import static utilz.Constants.GameContainer.TARGET_UPS;


public class MessageManager
{
    private static class Message {
        private final String message;
        private final static int MESSAGE_DURATION = 4 * TARGET_UPS;
        private int counter = MESSAGE_DURATION;

        public Message(String message) {
            this.message = message;
        }

        public boolean isExpired() {
            counter--;
            return counter <= 0;
        }
        @Override
        public String toString() {
            return message;
        }
    }

    private final ArrayList<Message> messages;

    public MessageManager() {
        messages = new ArrayList<>();
    }

    public void displayMessages(Graphics2D g2d) {

        int offsetY = 200;
        final int spaceBetween = 40;
        final int offsetX = 10;

        g2d.setColor(Color.white);
        g2d.setFont(ARIAL_10);

        // COLLECT EXPIRED MESSAGES
        ArrayList<Message> removeMessages = new ArrayList<>();

        for (Message message : messages) {
            // DRAW MESSAGE
            g2d.drawString(message.toString(), offsetX, offsetY);
            offsetY += spaceBetween;

            // CHECK IF EXPIRED
            if (message.isExpired())
                removeMessages.add(message);
        }

        // REMOVE EXPIRED MESSAGES
        for (Message message : removeMessages)
            messages.remove(message);
    }

    public void addMessage(String message) {
        messages.add(new Message(message));
    }
}
