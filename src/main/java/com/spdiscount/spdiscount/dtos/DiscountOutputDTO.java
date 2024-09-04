package com.spdiscount.spdiscount.dtos;

/**
 * Classe DiscountOutputDTO
 * Esta classe representa o DTO (Data Transfer Object) para a saída do desconto das compras.
 * Atributos:
 * - operation: Informações sobre o objeto comprado, valores, etc.
 * - sellValue: O preço total da compra pós descontos.
 */
public class DiscountOutputDTO {

    private Operation operation;
    private double sellValue;

    public DiscountOutputDTO() {
    }

    public DiscountOutputDTO(Operation operation, double sellValue) {
        this.operation = operation;
        this.sellValue = sellValue;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double getSellValue() {
        return sellValue;
    }

    public record Operation(String objectName, double value) {

        Operation() {
            this("", 0.0);
        }
    }
}