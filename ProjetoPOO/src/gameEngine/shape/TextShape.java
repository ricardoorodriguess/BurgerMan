package gameEngine.shape;

import java.awt.*;
import java.io.InputStream;

public class TextShape extends Shape {
    private String text;
    private final Color color;
    private final int fontSize;
    private Font font;

    public TextShape(String initialText, Color color, int fontSize) {
        super(null); // O GameObject será associado depois
        this.text = initialText;
        this.color = color;
        this.fontSize = fontSize;

        try (InputStream is = getClass().getResourceAsStream("/fonts/pacmanFont.TTF")) {
            if (is == null) {return;}
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
            this.font = baseFont.deriveFont((float) this.fontSize);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao carregar a fonte: /fonts/pacmanFont.TTF", e);
        }
    }

    public void setText(String newText) {
        this.text = newText;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        int x = -metrics.stringWidth(text) / 2; //centraliza o texto horizontalmente
        int y = metrics.getAscent() / 2; //ajusta verticalmente
        g.drawString(text, x, y);
    }
}