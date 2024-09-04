package com.spdiscount.spdiscount;

import com.spdiscount.spdiscount.dtos.DiscountOutputDTO;
import com.spdiscount.spdiscount.services.impl.DiscountServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicação de desconto simplificada
 * Esta aplicação permite ao usuário inserir o nome do objeto e seu valor, e então calcula o valor de venda com desconto.
 * A aplicação também exibe o nome do objeto, seu valor e o valor de venda com desconto.
 * Esta aplicação utiliza a interface gráfica Swing para exibir os resultados.
 *
 * @Author: Gustavo Toledo
 */
public class SpDiscountSimplifiedApplication extends JPanel {

    public SpDiscountSimplifiedApplication(DiscountOutputDTO discountOutputDTO) {
        setLayout(new GridLayout(4, 3));

        JLabel objectNameLabel = new JLabel("Item:");
        JLabel objectNameValue = new JLabel(discountOutputDTO.getOperation().objectName());
        JLabel valueLabel = new JLabel("Preço do Item:");
        JLabel valueValue = new JLabel(String.valueOf(discountOutputDTO.getOperation().value()));
        JLabel sellValueLabel = new JLabel("Valor de venda (com descontos):");
        JLabel sellValueValue = new JLabel(String.valueOf(discountOutputDTO.getSellValue()));

        add(objectNameLabel);
        add(objectNameValue);
        add(valueLabel);
        add(valueValue);
        add(sellValueLabel);
        add(sellValueValue);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Discount Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel objectNameLabel = new JLabel("Item:");
        JTextField objectNameField = new JTextField(15);
        JLabel valueLabel = new JLabel("Preço do item:");
        JTextField valueField = new JTextField(15);
        JButton submitButton = new JButton("Calcular Desconto");

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(objectNameLabel, gbc);

        gbc.gridx = 1;
        frame.add(objectNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(valueLabel, gbc);

        gbc.gridx = 1;
        frame.add(valueField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String objectName = objectNameField.getText();
                double value = Double.parseDouble(valueField.getText());

                DiscountServiceImpl discountService = new DiscountServiceImpl();
                DiscountOutputDTO discountOutputDTO = discountService.applyDiscount(objectName, value);

                JFrame outputFrame = new JFrame("Discount Output");
                outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                outputFrame.add(new SpDiscountSimplifiedApplication(discountOutputDTO));
                outputFrame.pack();
                outputFrame.setVisible(true);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}