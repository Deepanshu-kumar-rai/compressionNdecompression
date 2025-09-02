/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import comp_decomp.compressor;
import comp_decomp.decompressor;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    // Constructor
    public AppFrame() {
        super("CompX - Compression Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null); // center window on screen
        this.setLayout(new BorderLayout());

        // ---------- Heading Panel ----------
        JPanel headingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Gradient background
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(58, 123, 213),
                        getWidth(), getHeight(), new Color(58, 213, 151)
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        headingPanel.setLayout(new BorderLayout());
        headingPanel.setPreferredSize(new Dimension(900, 140));

        // Title
        JLabel headingLabel = new JLabel("CompX", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Tagline
        JLabel tagline = new JLabel("Shrink It. Save It. Send It", SwingConstants.CENTER);
        tagline.setFont(new Font("SansSerif", Font.PLAIN, 18));
        tagline.setForeground(new Color(230, 230, 230));
        tagline.setBorder(BorderFactory.createEmptyBorder(0, 10, 20, 10));

        JPanel titleBox = new JPanel(new BorderLayout());
        titleBox.setOpaque(false);
        titleBox.add(headingLabel, BorderLayout.NORTH);
        titleBox.add(tagline, BorderLayout.SOUTH);

        headingPanel.add(titleBox, BorderLayout.CENTER);
        this.add(headingPanel, BorderLayout.NORTH);

        // ---------- Button Card Panel ----------
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(new Color(245, 245, 245));

        JPanel buttonCard = new JPanel(new GridBagLayout());
        buttonCard.setBackground(Color.WHITE);
        buttonCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                BorderFactory.createEmptyBorder(40, 60, 40, 60)
        ));

        compressButton = createStyledButton("📂  Select File to Compress");
        decompressButton = createStyledButton("📂  Select File to Decompress");

        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonCard.add(compressButton, gbc);

        gbc.gridy = 1;
        buttonCard.add(decompressButton, gbc);

        cardPanel.add(buttonCard);
        this.add(cardPanel, BorderLayout.CENTER);

        // ---------- Footer ----------
        JLabel footerLabel = new JLabel("© 2025 CompX | Smart File Compression", SwingConstants.CENTER);
        footerLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        footerLabel.setForeground(Color.DARK_GRAY);
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(footerLabel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // Helper method to create stylish rounded buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Button background
                if (getModel().isPressed()) {
                    g2.setColor(new Color(0, 102, 204));
                } else if (getModel().isRollover()) {
                    g2.setColor(new Color(30, 144, 255).darker());
                } else {
                    g2.setColor(new Color(30, 144, 255));
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
                g2.dispose();
            }
        };

        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(280, 55));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try {
                    compressor.method(file);
                    JOptionPane.showMessageDialog(
                            null,
                            "File compressed successfully!",
                            "Compression Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error compressing file: " + ee.toString(),
                            "Compression Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try {
                    decompressor.method(file);
                    JOptionPane.showMessageDialog(
                            null,
                            "File decompressed successfully!",
                            "Decompression Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error decompressing file: " + ee.toString(),
                            "Decompression Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
    }

    // Main method to run
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppFrame::new);
    }
}
