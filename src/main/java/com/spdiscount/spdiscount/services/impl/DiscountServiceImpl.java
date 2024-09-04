package com.spdiscount.spdiscount.services.impl;

import com.spdiscount.spdiscount.dtos.DiscountOutputDTO;
import com.spdiscount.spdiscount.services.DiscountService;

/**
 * Implementação do serviço de desconto.
 */
public class DiscountServiceImpl implements DiscountService {

    @Override
    public DiscountOutputDTO applyDiscount(String objectName, double value) {
        var discountValue = calculateDiscountValue(value);
        return new DiscountOutputDTO(new DiscountOutputDTO.Operation(objectName, value), value - discountValue);
    }

    private double calculateDiscountValue(double value) {
        if (value > 300) return value * 0.15;
        if (value > 200 && value < 300) return value * 0.1;
        return value * 0.05;
    }
}
