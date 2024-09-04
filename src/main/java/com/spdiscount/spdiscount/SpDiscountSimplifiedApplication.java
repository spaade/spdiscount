package com.spdiscount.spdiscount;

import com.spdiscount.spdiscount.dtos.DiscountOutputDTO;
import com.spdiscount.spdiscount.services.impl.DiscountServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Aplicação de desconto simplificada
 * Esta aplicação permite ao usuário inserir o nome do objeto e seu valor, e então calcula o valor de venda com desconto.
 * A aplicação também exibe o nome do objeto, seu valor e o valor de venda com desconto.
 * Esta aplicação utiliza a interface gráfica Swing para exibir os resultados.
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
        DiscountServiceImpl discountService = new DiscountServiceImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Item:");
        String objectName = scanner.nextLine();
        System.out.println("Preço do item:");
        double value = scanner.nextDouble();

        DiscountOutputDTO discountOutputDTO = discountService.applyDiscount(objectName, value);
        System.out.println("Valor de venda (com descontos): " + discountOutputDTO.getSellValue());

        JFrame frame = new JFrame("Discount Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SpDiscountSimplifiedApplication(discountOutputDTO));
        frame.pack();
        frame.setVisible(true);
    }
}